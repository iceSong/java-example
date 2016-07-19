import org.junit.Test;

import java.util.Optional;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-07-16 18:06
 */
public class OptionalTest {
    @Test
    public void orElse_whenNamePresent_ThenName(){
        Optional<String> petName = Optional.empty();
        System.out.println(petName.orElse(""));
    }
}

