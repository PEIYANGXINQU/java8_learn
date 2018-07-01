package chapter3_lambda表达式;

import com.cris.simpledemo.Apple;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName ConstructorMethodCallingTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ConstructorMethodCallingTest {

    public static void main(String[] args) {

        /*无参构造方法引用*/
        Supplier<Apple> supplier = () -> new Apple();
        Apple apple = supplier.get();

        Supplier<Apple> supplier1 = Apple::new;
        Apple apple1 = supplier1.get();
        System.out.println(apple1);


        List<Apple> applesByWeight = getApplesByWeight(Arrays.asList(1.0, 3.0, 4.2), Apple::new);
        // 上下等价
        List<Apple> apples = getApplesByWeight(Arrays.asList(2.5, 3.9), (weight) -> new Apple(weight));
        applesByWeight.forEach(System.out::println);
        //Apple{color='null', weight=1.0}
        //Apple{color='null', weight=3.0}
        //Apple{color='null', weight=4.2}

        /*传入一个包含颜色和重量的map，返回一个个苹果集合*/
        Map<String, List> map = new HashMap<>();
        map.put("color", Arrays.asList("green", "red"));
        map.put("weight", Arrays.asList(23.0, 12.9));
        List<Apple> applesByWeightAndColor = getApplesByWeightAndColor(map, Apple::new);
        applesByWeightAndColor.forEach(System.out::println);
        //Apple{color='green', weight=23.0}
        //Apple{color='red', weight=12.9}

    }

    public static List<Apple> getApplesByWeightAndColor(Map<String, List> map, BiFunction<String, Double, Apple> biFunction) {
        Set<Map.Entry<String, List>> entries = map.entrySet();
        List<String> colors = null;
        List<Double> weights = null;
        for (Map.Entry<String, List> entry : entries) {
            String key = entry.getKey();
            if ("color".equals(key)) {
                colors = entry.getValue();
                continue;
            }
            if ("weight".equals(entry.getKey())) {
                weights = entry.getValue();
                continue;
            }
        }

        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < colors.size(); i++) {
            /*颜色必须和重量一一对应*/
            Apple apply = biFunction.apply(colors.get(i), weights.get(i));
            apples.add(apply);
        }
        return apples;
    }

    public static List<Apple> getApplesByWeight(List<Double> list, Function<Double, Apple> function) {
        List<Apple> apples = new ArrayList<>();
        for (Double d : list) {
            Apple apple = function.apply(d);
            apples.add(apple);
        }
        return apples;
    }
}
