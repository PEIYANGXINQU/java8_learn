package chapter6_流收集数据;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName IsPrimeTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class IsPrimeTest {

    public static void main(String[] args) {

        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(3, 10).boxed().collect(Collectors.partitioningBy(x -> isPrime(x)));
        System.out.println(collect);

    }

    // 判断质数和非质数的标准：看这个数是否可以被2到它的平方根的任意整数整除，如果可以，这个数就是非质数
    public static boolean isPrime(int number) {

        int x = (int) Math.sqrt(number);
        return IntStream.rangeClosed(2, x).noneMatch(y -> number % y == 0);
    }
}
