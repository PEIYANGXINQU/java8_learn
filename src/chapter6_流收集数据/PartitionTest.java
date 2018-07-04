package chapter6_流收集数据;

import chapter4_流.Dish;
import chapter4_流.Type;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @ClassName PartitionTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class PartitionTest {
    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 850, Type.FISH)
        );
    }

    public static void main(String[] args) {

        Map<Boolean, Dish> collect = dishes.stream().collect(partitioningBy(Dish::getVegetarian, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(collect);

        /*// 多级分区，先将所有菜按照荤素进行分区，然后按照类别进行划分
        Map<Boolean, Map<Type, List<Dish>>> collect = dishes.stream().collect(partitioningBy(Dish::getVegetarian, groupingBy(Dish::getType)));*/


      /*  Map<Boolean, List<Dish>> collect = dishes.stream().collect(partitioningBy(Dish::getVegetarian));
        System.out.println(collect);

        List<Dish> collect1 = dishes.stream().filter(Dish::getVegetarian).collect(Collectors.toList());*/


    }

}
