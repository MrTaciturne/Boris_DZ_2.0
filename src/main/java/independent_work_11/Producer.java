package independent_work_11;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Producer implements Runnable{

    private static Random random = new Random();

    BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        random.setSeed(random.nextLong());
        while (queue.remainingCapacity() != 0) {
            queue.add(random.nextInt(10));
            try {
                wait(random.nextInt(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
