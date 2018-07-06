package chapter8_重构_测试_调试;

import com.cris.simpledemo.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.summingDouble;

/**
 * @ClassName AppleTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class AppleTest {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 12.2), new Apple("red", 11.1));
        apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(apples);
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(apples);

        Optional<Double> reduce = apples.stream().map(Apple::getWeight).reduce((x, y) -> x + y);
        Double collect = apples.stream().collect(summingDouble(Apple::getWeight));
        double sum = apples.stream().mapToDouble(Apple::getWeight).sum();

    }
}
