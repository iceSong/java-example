import lombok.Data;

/**
 * 使用Lombok的bean可以避免写get/set/constructor/tostring等方法
 *
 * @author song@liu@ele.me
 * @date 2016-09-06 16:31
 */
@Data
public class BeanA{
    private String name;
    private int age;
}
