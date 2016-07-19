package hello;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-07-18 14:01
 */
@FunctionalInterface
public interface HigherOrderRunnable {
    Runnable combine(Runnable... runnables);
}
