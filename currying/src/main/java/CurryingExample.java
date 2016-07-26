import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-07-25 15:54
 */
public class CurryingExample {
    public static void main(String[] args){
        //使用自定义的函数接口
        FunInterFace a = x -> x + 1;
        Arrays.asList(1,2,3,4,5,6).stream().map(a::hi).collect(Collectors.toList()).forEach(System.out::println);

        //使用系统默认的Function
        Arrays.asList(1,2,3,4,5,6).stream().map(calculation(2, 3)).collect(Collectors.toList()).forEach(System.out::println);

    }

    //定义函数规则
    static Function<Integer, Function<Integer, Function<Integer, Integer>>> calculation = x -> y -> z -> x + y * z;
    static Function<Integer, Integer> calculation(Integer x, Integer y) {
        return calculation.apply(x).apply(y);
    }

    private Stream<Integer> calculate(Stream<Integer> stream, Integer a, Integer b) {
        return stream.map(calculation(a, b));
    }

    public <A, B, C> Function<A, Function<B, C>> curry(final BiFunction<A, B, C> f){
        return (A a) -> (B b) -> f.apply(a, b);
    }

    public <A, B, C> BiFunction<A, B, C> uncurry(Function<A, Function<B, C>> f){
        return (A a, B b) -> f.apply(a).apply(b);
    }
}
