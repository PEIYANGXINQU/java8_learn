package com.cris.simpledemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// lambda就是将函数作为值（一等公民）进行传递，StreamAPI 就是将数据进行串行或者并行处理
public class AppleFilter {

    public static List<Apple> filterByColor(List<Apple> apples){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: apples
             ) {
            if ("green".equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    public static List<Apple> filterByWeight(List<Apple> apples){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: apples
             ) {
            if(apple.getWeight() > 30){
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args){
        List<Apple> list = Arrays.asList(new Apple("green", 23.4), new Apple("red", 80.3), new Apple("green", 90.2));
        List<Apple> list1 = filterByColor(list);
        List<Apple> list2 = filterByWeight(list);
        list1.forEach(System.out::println);
        System.out.println("-------------");
        list2.forEach(System.out::println);

        System.out.println("=========lambda===========");
        List<Apple> list4 = filterByWeightAndLambda(list, (Apple apple) -> "green".equals(apple.getColor()));
        List<Apple> list3 = filterByWeightAndLambda(list, (Apple apple) -> apple.getWeight() > 30);
        List<Apple> list5 = filterByWeightAndLambda(list, (Apple apple) -> apple.getWeight() > 30 && "green".equals(apple.getColor()));
        list3.forEach(System.out::println);
        System.out.println("---------------");
        list4.forEach(System.out::println);
        System.out.println("---------------");
        list5.forEach(System.out::println);

    }

    public static List<Apple> filterByWeightAndLambda(List<Apple> apples, Predicate<Apple> predicate){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: apples
             ) {
            if (predicate.test(apple)){
                list.add(apple);
            }
        }
        return list;
    }

}
