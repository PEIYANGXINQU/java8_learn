package chapter5_流的具体使用;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName ExtraCase
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ExtraCase {

    // 从100 删选出所有的勾股数（a*a + b*b 的和的开方可以得到c）组合
    // 1. 从1-100范围里一次取出a，然后对于a进行flatMap操纵
    // 2. flagMap 操作中对每一个a都取出a-100中的所有数b依次获得满足勾股数定理的数组泛型的Stream，
    // 3. 过滤得到的Stream，确保c必须是整数
    // 4. 最后得到double类型的stream，依次打印这个流中每个元素(double数组)里面的每个值
    public static void main(String[] args) {
        Stream<double[]> stream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(x ->
                        IntStream.rangeClosed(x, 100)
                                .mapToObj(y -> new double[]{x, y, Math.sqrt(x * x + y * y)})
                                .filter(t -> t[2] % 1 == 0));
        stream.forEach(x -> System.out.println(x[0] + "----" + x[1] + "-----" + x[2]));


    }

}
