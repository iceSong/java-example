import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @date 2016-09-06 17:05
 */
@ToString(callSuper = true)
public class BeanC extends BeanB {
    @Getter @Setter private boolean hasTail;
}
