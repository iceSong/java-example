import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @date 2016-09-06 16:51
 */
@ToString
public class BeanB {
    @Getter @Setter private String dog;
    @Setter(AccessLevel.PUBLIC) private int num;
    @Getter @Setter private boolean isAnimal;
}
