package chapter5_流的具体使用;

import java.util.stream.Stream;

/**
 * @ClassName CreateStreamTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class CreateStreamTest {

    public static void main(String[] args) {

/*        Stream<String> stringStream = Stream.of("cris", "abc", "jjl").map(String::toUpperCase);
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
        }*/

        /*     Stream.iterate(0, n -> n+2).limit(10).forEach(System.out::println);
         *//*斐波拉契元祖数列*//*
        Stream<int[]> limit = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(5);
        limit.forEach(n -> System.out.print("("+ n[0] + "," + n[1] +"), "));
        *//*斐波拉契数列*//*
        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1],n[0]+n[1]}).limit(10).map(n -> n[0]).forEach(n -> System.out.print(n+","));
*/
        Stream<Integer> limit1 = Stream.generate(() -> (int) (Math.random() * 10)).limit(10);
        limit1.forEach(System.out::println);

    }
}
