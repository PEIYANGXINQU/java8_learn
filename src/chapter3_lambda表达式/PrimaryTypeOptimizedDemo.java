package chapter3_lambda表达式;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*基本数据类型和引用数据类型之间的装箱/解箱优化*/
public class PrimaryTypeOptimizedDemo {

    public static void main(String[] args){
        // 优化后的断言型接口
        IntPredicate intPredicate = (x) -> x>10;
        //  没有优化的断言型接口（需要制定泛型）
        Predicate<Integer> predicate = (x) -> x>10;
        System.out.println(intPredicate.test(100));
        System.out.println(predicate.test(4));
    }
}
