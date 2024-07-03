import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class ComplexTaskExecutor {

    private final CyclicBarrier barrier;
    private final ExecutorService executor;
    private final int numberOfTasks;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.barrier = new CyclicBarrier(numberOfTasks, () -> System.out.println("Все задачи выполнены!"));
        this.executor = Executors.newFixedThreadPool(numberOfTasks);
        this.numberOfTasks = numberOfTasks;
    }

    public void executeTasks() throws InterruptedException {
        for (int i = 0; i < numberOfTasks; i++) {
            int taskNumber = i + 1;
            executor.execute(() -> {
                new ComplexTask(taskNumber).execute();
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        sleep(10000);
        executor.shutdown();
    }

}
