import org.junit.Test;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-07-18 11:51
 */
public class HigherOrderRunnables {
    @Test
    public void runnavbleTest(){
        Runnable blockOfCode = () -> {
            System.out.println("Q: What was the weather like in winter of 2015?");
            System.out.println("A: It was very cold");
        };

        blockOfCode.run();
    }

}
