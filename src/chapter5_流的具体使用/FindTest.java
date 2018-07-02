package chapter5_流的具体使用;

import chapter4_流.Dish;
import chapter4_流.Type;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class FindTest {
    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 900, Type.FISH)
        );
    }

    public static void main(String[] args) {
        // 注意返回的是一个容器类对象Optional，可以有效对包裹在里面的数据进行null 判断
//        Optional<Dish> any = dishes.stream().filter(dish -> dish.getCalories() > 500).findAny();

        /*找到卡路里满足大于300的任意一道菜，如果存在就打印名字,list有序所以打印的是卡路里最高的*/
        dishes.stream().filter(dish -> dish.getCalories() > 300).findAny().ifPresent(dish -> System.out.println(dish.getName()));

    }
}
