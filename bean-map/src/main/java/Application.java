import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 使用Orika进行对象映射,类似的还有Spring的BeanUtils
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-09-05 16:11
 */
public class Application {
    public static void main(String[] args){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(BeanA.class, BeanB.class)
                .field("fieldA", "age")
                .field("fieldB", "name")
                .register();

        BeanA ba = new BeanA();
        ba.setFieldA(12);
        ba.setFieldB("song");

        BeanB bb = mapperFactory.getMapperFacade().map(ba, BeanB.class);
        System.out.println(bb);

        BoundMapperFacade<BeanA, BeanB> boundMapper = mapperFactory.getMapperFacade(BeanA.class, BeanB.class);
        System.out.println(boundMapper.map(ba));

        // 由后者转化为前者
        BeanB source = new BeanB();
        source.setAge(20);
        source.setName("king");
        System.out.println(boundMapper.mapReverse(source));
        System.out.println(boundMapper.mapReverse(source, new BeanA()));
    }
}
