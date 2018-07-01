package chapter3_lambda表达式;

import com.cris.simpledemo.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName LambdaCombinationTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class LambdaCombinationTest {

    public static void main(String[] args) {
        /*根据苹果的重量进行排序的最终优化方法*/
        List<Apple> apples = Arrays.asList(new Apple("green", 20.1), new Apple("red", 10.3), new Apple("green", 18.0), new Apple("yello", 10.3));
        /*apples.sort(Comparator.comparing(Apple::getWeight));
        apples.forEach(System.out::println);*/

        /*默认是升序排序，如果想要降序排序的话很简单*/
//        apples.sort(Comparator.comparing(Apple::getWeight).reversed());

        /*如果重量一样的情况下，如何排序？*/
//        apples.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));

        Predicate<Apple> greenApple = apple -> "green".equals(apple.getColor());
//        sortByCondition(greenApple, new Apple("green", 230.3));
        // 测试非
        Predicate<Apple> notGreenApple = greenApple.negate();
//        sortByCondition(notGreenApple, new Apple("green", 11.1));

        // 测试lambda连接复合判断: a.and(b).or(c) 等价于 （a || b）&& c
        Predicate<Apple> predicate2 = greenApple
                .and(apple -> apple.getWeight() > 20.1)
                .or(apple -> "red".equals(apple.getColor()));

        sortByCondition(predicate2, new Apple("green", 22.2));
        sortByCondition(predicate2, new Apple("red", 11.1));

        apples.forEach(System.out::println);
    }

    /*根据断言型接口来判断苹果*/
    public static void sortByCondition(Predicate<Apple> predicate, Apple apple) {
        if (predicate.test(apple)) {
            System.out.println("--------hello------------apple");
        }
    }
}
