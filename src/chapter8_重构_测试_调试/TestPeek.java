package chapter8_重构_测试_调试;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestPeek {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> collect = list.stream().map(x -> x + 5).peek(x -> System.out.println("map:" + x))
                .filter(x -> x > 6).peek(x -> System.out.println("filter:" + x))
                .collect(Collectors.toList());

    }

}
