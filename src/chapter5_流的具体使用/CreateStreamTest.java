package chapter5_流的具体使用;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName CreateStreamTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class CreateStreamTest {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("cris", "abc", "jjl").map(String::toUpperCase);
        stringStream.forEach(System.out::println);

        int[] arr = {1, 4, 5, 9};
        int sum = Arrays.stream(arr).sum();     // 将基本数据类型的数组直接转换为IntStream
        System.out.println(sum);

        try (Stream<String> lines = Files.lines(Paths.get("demo.txt"))) {
//            long count = lines.map(x -> x.split(" ")).flatMap(Arrays::stream).distinct().count();
            long count = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
