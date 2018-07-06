package chapter8_重构_测试_调试;

/**
 * @ClassName LambdaTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class LambdaTest {

    public static void main(String[] args) {
        int a = 10;
        Runnable runnable = () -> {
//            int a = 10;       // 编译出错
            int b = 20;
            System.out.println(a);
//            System.out.println(this);     // 编译出错
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                int a = 5;
                System.out.println(a);
                System.out.println(this);
            }
        };
        new Thread(runnable).start();
        new Thread(runnable1).start();
    }
}
