package independent_work_11;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable, AutoCloseable{
    private static Random random = new Random();
    private final int MAX_SIZE;
    volatile BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue, int maxSize) {
        this.queue = queue;
        MAX_SIZE = maxSize;
    }

    @Override
    public synchronized void run() {
        random.setSeed(random.nextLong());
        System.out.println("Consumer rady");

        while (true){
            try {
                if (!queue.isEmpty()) {
                    System.out.println("Current que inner = " + queue.toString());
                    System.out.println("Take integer = " + queue.take());
                    System.out.println("Current que size = " + queue.size());
                    System.out.println("Current que inner = " + queue.toString() + "\n");
//                    wait();
                    TimeUnit.SECONDS.sleep(random.nextInt(10) + 2);
//                    notify();
//                } else {
//                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            if (queue.size() < MAX_SIZE) {
//                notifyAll();
//            }

        }
//        while (true){
//            while (!queue.isEmpty()){
//                try {
//                    System.out.println("Take integer = " + queue.take());
//                    System.out.println("Current que size = " + queue.size());
//                    System.out.println("Current que inner = " + queue.toString() + "\n");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//
//                }
//                try {
//                    TimeUnit.SECONDS.sleep(random.nextInt(10));
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }

    }

    @Override
    public void close() throws Exception {

    }
}
