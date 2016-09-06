/**
 * 使用Lombok来减少大量重复、有共性的代码
 *
 * @author song@liu@ele.me
 * @date 2016-09-06 16:36
 */
public class Application {

    public static void main(String[] args){
        BeanA ba = new BeanA();
        ba.setAge(20);
        ba.setName("song");
        System.out.println(ba.toString());

        BeanB bb = new BeanB();
        bb.setAnimal(true);  // 会对is、has开头的boolean属性处理
        bb.setNum(10);
        bb.setDog("汪汪");
        System.out.println(bb.toString());


        BeanC bc = new BeanC();
        bc.setAnimal(true);
        bc.setDog("ste");
        bc.setNum(2);
        bc.setHasTail(true);

        System.out.println(bc.toString());
    }

}
