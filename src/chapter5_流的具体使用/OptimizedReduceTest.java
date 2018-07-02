package chapter5_流的具体使用;

import chapter4_流.Dish;
import chapter4_流.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName OptimizedReduce
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class OptimizedReduceTest {
    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 900, Type.FISH)
        );
    }

    public static void main(String[] args) {
        // 计算所有菜系的卡路里之和
        Integer reduce = dishes.stream().map(dish -> dish.getCalories()).reduce(0, Integer::sum);
        System.out.println(reduce);

        // 优化后的reduce（使用数值流优化,降低装箱数据带来的效率下降，并且数值流直接支持sum，average，max等操作）
        int sum = dishes.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

        Stream<Integer> boxed = dishes.stream().mapToInt(Dish::getCalories).boxed();
        boxed.forEach(System.out::println);

        /*包含100*/
        long count = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0).count();
        System.out.println(count);
        /*不包含100*/
        long count1 = IntStream.range(1, 100).filter(x -> x % 2 == 0).count();
        System.out.println(count1);
    }

}
