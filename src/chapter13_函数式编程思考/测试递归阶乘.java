package chapter13_函数式编程思考;

import java.util.stream.IntStream;

/**
 * @ClassName 测试递归
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class 测试递归阶乘 {

    public static void main(String[] args) {
        int caculate = caculate(5);
        int i = caculateRecursive(5);
        int i1 = caculateOptimized(5);
        System.out.println(caculate + "----" + i + "=====" + i1);
    }

    // 第一种方法计算阶乘
    public static int caculate(int i) {
        if (i <= 1) {
            return i;
        }
        int a = 1;
        for (int b = 1; b <= i; b++) {
            a *= b;
        }
        return a;
    }

    // 第二种方法计算阶乘(不推荐)
    public static int caculateRecursive(int i) {
        return i == 1 ? 1 : i * caculateRecursive(i - 1);
    }

    // 使用lambda 表达式优化
    public static int caculateOptimized(int i) {
        return i == 1 ? 1 : IntStream.rangeClosed(1, i).reduce(1, (a, b) -> a * b);
    }


}
