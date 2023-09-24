package independent_work_11;

import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread consumer = new Thread(new Consumer(queue, 10));
        Thread producer = new Thread(new Producer(queue, 10));

        try {
            consumer.start();
            producer.start();
//            ExecutorService service = Executors.newFixedThreadPool(2);
//            service.submit(new Producer(queue, 10));
//            service.submit(new Consumer(queue, 10));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
