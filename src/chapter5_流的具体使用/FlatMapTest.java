package chapter5_流的具体使用;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName FlatMapTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class FlatMapTest {

    public static void main(String[] args) {
        /*1. 计算每个数字的平方并返回*/
     /*   List<Integer> list = Arrays.asList(1, 3, 7, 5);
        list.stream().map(x -> x*x).forEach(System.out::println);*/

        /*2. 计算两个数组之间的两两组合，例如（1,2），（3,4）返回[(1,3),(1,4),(2,3),(2,4)]*/
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3, 4);
        // 这种情况需要注意使用flatMap
//        List<Stream<int[]>> collect = list1.stream().map(x -> list2.stream().map(y -> new int[]{x, y})).collect(Collectors.toList());
/*        List<int[]> collect = list1.stream().flatMap(x -> list2.stream().map(y -> new int[]{x, y})).collect(Collectors.toList());
        for (int[] ints : collect) {
            System.out.println(ints[0]+"---"+ints[1]);
        }*/

        // 3. 计算2中两两组合之和可以被3整除的组合
        List<int[]> collect = list1.stream().flatMap(x -> list2.stream().filter(y -> (x + y) % 3 == 0).map(y -> new int[]{x, y})).collect(Collectors.toList());
        for (int[] ints : collect) {
            System.out.println(ints[0] + "---" + ints[1]);
        }

    }
}
