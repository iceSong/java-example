package hello;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-07-18 14:37
 */
public enum Sleeper {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7);

    private final int seconds;

    Sleeper(int seconds){
        this.seconds = seconds;
    }

    public void sleep() {
        System.out.printf("%s => Sleeping %d seconds...%n", this, seconds);
        // Countdown iteration: n, n - 1, ..., 0
        IntStream.iterate(seconds, i -> i - 1).limit(seconds).forEach(i -> {
            try {
                System.out.printf("%s => %d%n", this, i);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // Propagate interrupt status
                Thread.currentThread().interrupt();
                System.out.printf("%s => Interrupted!%n", this);
            }
        });
        System.out.printf("%s => 0. Waking up...%n", this);
    }
}
