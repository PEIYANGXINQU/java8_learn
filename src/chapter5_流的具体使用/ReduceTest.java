package chapter5_流的具体使用;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName ReduceTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ReduceTest {

    public static void main(String[] args) {
        // 规约求和
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        // 规约求积
        Integer reduce1 = list.stream().reduce(1, (x, y) -> x * y);
        System.out.println(reduce1);

        // 优化
        Integer reduce2 = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce2);

        Optional<Integer> reduce3 = list.stream().reduce(Integer::max);
        System.out.println(reduce3);        // Optional[4]
        Optional<Integer> reduce4 = list.stream().reduce(Integer::min);
        System.out.println(reduce4);        // Optional[1]

    }
}
