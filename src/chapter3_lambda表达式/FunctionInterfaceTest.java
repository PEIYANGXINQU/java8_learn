package chapter3_lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*测试功能型函数接口*/
public class FunctionInterfaceTest {

    public static void main(String[] args){
        test(Arrays.asList("cris", "hello", "abc"), (x) -> x.length());
    }

    public static void test(List<String> list, Function<String, Integer> function){
        List<Integer> list1 = new ArrayList<>();
        for (String str: list
             ) {
            list1.add(function.apply(str));
        }
        list1.forEach(System.out::println);
    }
}
