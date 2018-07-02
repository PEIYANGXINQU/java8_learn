package chapter4_流;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName InteratorTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class InteratorTest {

    private static List<Dish> dishes = null;

    static {
        dishes = Arrays.asList(new Dish("鲨鱼肉", false, 1000, Type.FISH),
                new Dish("炒牛肉", false, 800, Type.MEAT),
                new Dish("蔬菜沙拉", true, 400, Type.OTHER),
                new Dish("酸菜鱼", false, 900, Type.FISH)
        );
    }

    public static void main(String[] args) {
        // 1. 外部迭代
       /* for (Dish dish : dishes) {
                System.out.println(dish.getName());
        }*/

        // 2. 显示迭代
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        System.out.println("-----------------");
        // 3. 内部迭代
        dishes.stream().map(Dish::getName).forEach(System.out::println);
    }
}
