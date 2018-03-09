import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Cyrus
 * @version v1.0, 2018/1/31 下午4:56
 */
public class RateLimitApp {


    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(10d);

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Runnable runnable = () -> {
            rateLimiter.acquire();
            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
        };

        for( int i=0; i< 10; i++){
            executorService.execute(runnable);
        }

    }


}
