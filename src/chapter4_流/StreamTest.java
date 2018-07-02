package chapter4_流;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class StreamTest {

    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 900, Type.FISH)
        );
    }

    /*找出热量最高的2道菜的菜名*/
    public static void main(String[] args) {
        List<String> collect = dishes.stream()
                .filter(x -> x.getCalories() > 600)
                .sorted(Comparator.comparing(Dish::getCalories).reversed())     //默认升序，降序需要使用reversed（）
                .map(Dish::getName)
                .limit(2)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
