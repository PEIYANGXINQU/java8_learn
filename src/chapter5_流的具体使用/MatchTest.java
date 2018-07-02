package chapter5_流的具体使用;

import chapter4_流.Dish;
import chapter4_流.Type;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MatchTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class MatchTest {
    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 900, Type.FISH)
        );
    }

    public static void main(String[] args) {
        boolean b = dishes.stream().anyMatch(dish -> dish.getType() == Type.OTHER);
        System.out.println(b);      // true

        boolean b1 = dishes.stream().allMatch(dish -> dish.getCalories() < 950);
        System.out.println(b1);

        boolean b2 = dishes.stream().noneMatch(dish -> dish.getCalories() > 900);
        System.out.println(b2);
    }

}
