package chapter3_lambda表达式;

import java.io.InputStream;
import java.util.function.Predicate;

/*测试内置的断言型接口*/
public class PredicateInterfaceTest {

    public static void main(String[] args){
        test(1, (x) -> x>5);
        System.out.println("---------------");
        test(6, (x) -> x>5);
    }

    public static void test(Integer i, Predicate<Integer> predicate){
        if(predicate.test(i)){
            System.out.println(i);
        }
    }
}
