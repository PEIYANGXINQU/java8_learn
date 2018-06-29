package chapter3_lambda表达式;
import java.util.function.Supplier;

/*测试供给型函数式接口*/
public class SupplierFunctionTest {
    public static void main(String[] args){
        test(() -> (int)(Math.random()*10));
    }
    public static void test(Supplier<Integer> supplier){
        System.out.println(supplier.get());
    }

}
