import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-09-05 16:09
 */
public class BeanB {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
