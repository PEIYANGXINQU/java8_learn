package chapter2_行为参数化;

import com.cris.simpledemo.Apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda_sort_demo {

    public static void main(String[] args){
        List<Apple> list = Arrays.asList(new Apple("green", 80.0), new Apple("green", 23.23), new Apple("red", 10.23));
        // 第一种方式
        /*list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return (int)(o1.getWeight() - o2.getWeight());
            }
        });
        list.forEach(System.out::println);*/

        // 第二种方式
        /*Collections.sort(list, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return (int)(o1.getWeight()-o2.getWeight());
            }
        });
        list.forEach(System.out::println);*/

        // 第三种方式(将当前list数据排序)
       /* list.sort((x,y) -> (int)(x.getWeight()-y.getWeight()));
        list.forEach(System.out::println);*/

        // 第四种方式（将当前list转换为stream进行排序，然后放进另外新建的list中）
      /*  List<Apple> collect = list.stream().sorted((x, y) -> (int) (x.getWeight() - y.getWeight())).collect(Collectors.toList());
        collect.forEach(System.out::println);
        list.forEach(System.out::println);      // 原list是没有排序的*/

        // 第五种方式
        list.sort((x, y) -> x.getWeight().compareTo(y.getWeight()));
        list.forEach(System.out::println);

    }
}
