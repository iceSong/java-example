import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author song@liu@ele.me
 * @version 0.01
 * @date 2016-07-25 17:51
 */
public class PrimitivesAndFunction {
    static IntFunction<IntFunction<IntUnaryOperator>> intToIntCalculation = x -> y -> z -> x + y * z;

    private static IntStream calculate(IntStream stream, int a, int b) {
        return stream.map(intToIntCalculation.apply(a).apply(b));
        // or return stream.map(((IntFunction<IntFunction<IntUnaryOperator>> intToIntCalculation) x -> y -> z -> x + y * z).apply(a).apply(b));
    }

    public static void main(String[] args){
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        IntStream newStream = calculate(stream, 3, 4);
        System.out.println(newStream.boxed().collect(Collectors.toList()));
    }
}
