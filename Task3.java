import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    private AtomicInteger processedCount = new AtomicInteger(0); // FIX

    public void process(ExecutorService executor, Runnable recordTask) {
        executor.submit(() -> {
            recordTask.run();
            processedCount.incrementAndGet(); // FIX
        });
    }

    public int getProcessedCount() {
        return processedCount.get(); // FIX
    }
}
