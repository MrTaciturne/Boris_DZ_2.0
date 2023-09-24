package independent_work_11;

import com.sun.tools.javac.util.List;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Runner {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10);

        try {
            ExecutorService service = Executors.newFixedThreadPool(2);
            service.submit(new Producer(queue));
            service.submit(new Consumer(queue));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
