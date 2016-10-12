package hello;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-07-18 14:03
 */
public class Application {
    public static void main(String[] args){
        /* first */
        HigherOrderRunnable higherOrderRunnable = (Runnable... runnables) -> {
            Runnable result = new Runnable() {
                @Override
                public void run() {
                    for(Runnable r: runnables){
                        r.run();
                    }
                }
            };
            return result;
        };

        /* second */
        HigherOrderRunnable h2 = (Runnable... runnables) -> {
            Runnable r = () -> {
                for(Runnable rn: runnables){
                    rn.run();
                }
            };
            return  r;
        };

        /* third */
        HigherOrderRunnable h3 = (Runnable... runnables) -> {
            Runnable result = () ->{
                Arrays.stream(runnables).forEach(Runnable::run);
            };
            return result;
        };


        /* fourth implement the functional interface */
        HigherOrderRunnable h4 = runnables -> () -> Arrays.stream(runnables).forEach(Runnable::run);
        Runnable ru = h4.combine(()->System.out.println("runnable1"), ()->System.out.println("runnable2"), ()->System.out.println("runnable3"));
        ru.run();


        /* use HigherOrderRunnable to test Sleeper */
        Runnable ru2 = h4.combine(Sleeper.TWO::sleep, Sleeper.THREE::sleep, Sleeper.FOUR::sleep, Sleeper.FIVE::sleep);
        ru2.run();  //execute sequentially


        /* fifth parallel execution */
        HigherOrderRunnable h5 = runnables -> () ->{
            try{
                CountDownLatch latch = new CountDownLatch(runnables.length);
                ExecutorService executor = Executors.newFixedThreadPool(6);
                Arrays.stream(runnables).forEach(task ->executor.submit(()-> {
                    task.run();
                    latch.countDown();
                }));
                latch.await();
                executor.shutdown();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };
        Runnable ru3 = h5.combine(Sleeper.TWO::sleep, Sleeper.THREE::sleep, Sleeper.FOUR::sleep, Sleeper.FIVE::sleep);
        ru3.run();

    }
}
