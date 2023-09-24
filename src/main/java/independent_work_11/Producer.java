package independent_work_11;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable, AutoCloseable{

    private static Random random = new Random();
    private final int MAX_SIZE;

    volatile BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> blockingQueue, int maxSize) {
        this.queue = blockingQueue;
        MAX_SIZE = maxSize;
    }

    @Override
    public synchronized void run() {
        random.setSeed(random.nextLong());
        System.out.println("Prducer rady");
        int number;

        while (true) {
            try {
                if (queue.size() < MAX_SIZE) {
                   number = random.nextInt(10);
                   queue.add(number);
                    System.out.println("   *** добавил " + number + " ***");
//                    notifyAll();
//                    wait();
                    TimeUnit.SECONDS.sleep(random.nextInt(7) + 2);
//                    notify();
//                } else {
//                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }



    }

    @Override
    public void close() throws Exception {

    }
}
