package chapter3_lambda表达式;

import java.util.function.Function;

/**
 * @ClassName FunctionCombinationTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class FunctionCombinationTest {

    public static void main(String[] args) {
        Function<Integer, Integer> function0 = x -> x + 1;
        Function<Integer, Integer> function1 = x -> x * 2;

        // 函数式接口之间的复合连接（顺序）
        Function<Integer, Integer> function2 = function0.andThen(function1);
        Integer apply = function2.apply(10);
        System.out.println(apply);

        //函数式接口之间的复合连接（倒叙）
        Function<Integer, Integer> function3 = function0.compose(function1);
        System.out.println(function3.apply(6));

    }

}
