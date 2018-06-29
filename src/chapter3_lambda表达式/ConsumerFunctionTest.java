package chapter3_lambda表达式;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*测试消费型接口*/
public class ConsumerFunctionTest {
    public static void main(String[] args){
        test(Arrays.asList(1,4,6,8), (i) -> System.out.println(i));
    }

    public static void test(List<Integer> list, Consumer<Integer> consumer){
        for (Integer i: list
             ) {
            consumer.accept(i);
        }
    }
}
