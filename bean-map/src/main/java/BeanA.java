import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-09-05 16:06
 */
public class BeanA {
    private int fieldA;
    private String fieldB;

    public int getFieldA() {
        return fieldA;
    }

    public void setFieldA(int fieldA) {
        this.fieldA = fieldA;
    }

    public String getFieldB() {
        return fieldB;
    }

    public void setFieldB(String fieldB) {
        this.fieldB = fieldB;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
