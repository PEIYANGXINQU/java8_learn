package chapter6_流收集数据;

import chapter4_流.Dish;
import chapter4_流.Type;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CollectorTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class CollectorTest {

    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 900, Type.FISH)
        );
    }

    public static void main(String[] args) {

       /* long count = dishes.stream().count();
        Long collect = dishes.stream().collect(counting());
        System.out.println(count == collect);*/
        /*通过收集器完成 统计卡路里最高的菜的需求*/
       /* Optional<Dish> collect1 = dishes.stream().collect(maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(collect1);*/

        /*计算所有的菜系卡路里之和（比我们之前使用map，然后reduce又简洁了不少）*/
        /*Integer collect1 = dishes.stream().collect(summingInt(Dish::getCalories));
        System.out.println(collect1);*/
/*        Integer collect3 = dishes.stream().collect(reducing(0, Dish::getCalories, (x, y) -> x + y));
        Integer collect4 = dishes.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        int sum = dishes.stream().mapToInt(Dish::getCalories).sum();*/

        /*一次性完成数据的所有常见统计操作（个数，求和，最值，平均值）*/
       /* IntSummaryStatistics collect2 = dishes.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(collect2);   //IntSummaryStatistics{count=4, sum=3100, min=400, average=775.000000, max=1000}*/

/*        String collect1 = dishes.stream().map(Dish::getName).collect(joining(","));
        System.out.println(collect1);
        String collect2 = dishes.stream().map(Dish::toString).collect(joining(","));
        System.out.println(collect2);*/


    }
}
