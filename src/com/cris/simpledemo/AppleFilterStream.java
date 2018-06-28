package com.cris.simpledemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*lambda表达式结合StreamAPI*/
public class AppleFilterStream {

    public static void main(String[] args){
        List<Apple> list = Arrays.asList(new Apple("green", 23.4), new Apple("red", 80.3), new Apple("green", 90.2));

        List<Apple> list1 = list.stream().filter((x) -> x.getWeight() > 30).collect(Collectors.toList());

        List<Apple> list2 = list.parallelStream().filter((x) -> "green".equals(x.getColor())).collect(Collectors.toList());
        list1.forEach(System.out::println);
        System.out.println("-----");
        list2.forEach(System.out::println);
    }
}
