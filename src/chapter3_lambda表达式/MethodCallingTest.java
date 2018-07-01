package chapter3_lambda表达式;

import com.cris.simpledemo.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

/**
 * @ClassName MethodCallingTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class MethodCallingTest {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 12.9), new Apple("red", 5.4), new Apple("green", 10.2));
        // 以前的写法
//     apples.sort((x,y) -> x.getWeight().compareTo(y.getWeight()));

        // 引入方法引用后的写法
        apples.sort(Comparator.comparing(Apple::getWeight));
        apples.forEach(System.out::println);

        /*静态方法引用*/
        ToIntFunction<String> function = x -> Integer.parseInt(x);
        int i = function.applyAsInt("123");
        System.out.println(i);

        ToIntFunction<String> function1 = Integer::parseInt;
        System.out.println(function1.applyAsInt("321"));

        /*对象方法引用*/
        String str = "cris";
        ToIntBiFunction<String, Character> function2 = (x, y) -> x.indexOf(y);
        int number = function2.applyAsInt(str, 'i');
        System.out.println(number);

        ToIntBiFunction<String, Character> function3 = String::indexOf;
        int s = function3.applyAsInt(str, 's');
        System.out.println(s);

        /*方法引用需要注意：引用的方法签名必须和当前的函数式接口一致*/
      /*  List<String> list = Arrays.asList("G", "B", "a", "z");
        list.sort((x, y) -> x.compareToIgnoreCase(y));
        list.forEach(System.out::print);*/

        List<String> list = Arrays.asList("b", "A", "Z", "k");
        list.sort(String::compareToIgnoreCase);
        list.forEach(System.out::print);

    }

}
