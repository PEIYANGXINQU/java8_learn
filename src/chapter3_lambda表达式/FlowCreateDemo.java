package chapter3_lambda表达式;

import com.cris.simpledemo.Apple;

import java.util.function.Function;

/**
 * @ClassName FlowCreateDemo
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class FlowCreateDemo {

    public static void main(String[] args) {
        Apple apple = new Apple("red", 22.2);
        Function<Apple, Apple> firstCheck = FlowCreateDemo::checkColor;
        Function<Apple, Apple> allCheck = firstCheck.andThen(FlowCreateDemo::checkWeight).andThen(FlowCreateDemo::checkBrand);
        Apple apply = allCheck.apply(apple);
        System.out.println(apply.getBrand());       // 红富士

        Apple green = allCheck.apply(new Apple("green", 2.1));
        System.out.println(green);

    }

    /*1. 检查苹果颜色*/
    public static Apple checkColor(Apple apple) {
        if (!("red".equals(apple.getColor()))) {
            throw new RuntimeException("颜色不对");
        } else {
            return apple;
        }
    }

    /*2. 检查苹果重量*/
    public static Apple checkWeight(Apple apple) {
        if (!(apple.getWeight() >= 10.0)) {
            throw new RuntimeException("重量不行");
        } else {
            return apple;
        }
    }

    /*3. 给苹果贴上商标*/
    public static Apple checkBrand(Apple apple) {
        apple.setBrand("红富士");
        return apple;
    }
}
