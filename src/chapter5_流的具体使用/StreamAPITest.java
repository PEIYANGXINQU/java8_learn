package chapter5_流的具体使用;

import chapter4_流.Dish;
import chapter4_流.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamAPITest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class StreamAPITest {

    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 900, Type.FISH)
        );
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 2, 6, 7);
        /*distict() 根据集合中元素的hashCode 和 equals 方法来去重*/
        list.stream().filter(x -> x % 2 == 0).distinct().forEach(System.out::println);

   /*     System.out.println("-----------------");

        Set<Integer> set = new HashSet<>(list);
        set.forEach(System.out::println);*/

        /*Set<Dish> set = new HashSet<>(dishes);
        set.stream().filter(x -> x.getCalories()>500).map(Dish::getName).forEach(System.out::println);*/

        // 筛选所有卡路里大于500的菜系，并且跳过第一个菜
     /*   List<Dish> collect = dishes.stream().filter(x -> x.getCalories() > 500).skip(1).collect(Collectors.toList());
        System.out.println("=============");
        collect.forEach(System.out::println);*/

        // 枚举判断使用 ==
//        dishes.stream().filter(x -> x.getType() == Type.FISH).map(Dish::getName).forEach(System.out::println);


        // Map 练习
        System.out.println("```````````````````");
       /* List<String> list1 = Arrays.asList("cris", "abc", "hello");
        list1.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);*/


//        dishes.stream().map(Dish::getName).map(String::length).forEach(System.out::println);

        // flatMap
        // 快速将一个数组转换为流进行操作
        String[] strings = {"abc", "crisa"};
        Stream<String> stream = Arrays.stream(strings);

        List<String> collect = Arrays.stream(strings)   // 数组转为流
                .map(x -> x.split(""))      // 这里返回Stream<String[]> 类型的子流
                .flatMap(Arrays::stream)        // 将每个子流中的数组平铺组合为一个Stream<String> 类型的组合流
                .distinct()                         // 在组合流中进行String 的去重
                .collect(Collectors.toList());
        collect.forEach(System.out::println);


    }


}
