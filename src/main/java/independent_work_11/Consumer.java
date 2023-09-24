package independent_work_11;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Consumer implements Runnable{
    private static Random random = new Random();
    BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        random.setSeed(random.nextLong());
        while (!queue.isEmpty()){
            try {
                System.out.println("Take integer = " + queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
            try {
                wait(random.nextInt(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
