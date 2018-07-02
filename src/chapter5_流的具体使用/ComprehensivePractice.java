package chapter5_流的具体使用;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName ComprehensivePractice
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ComprehensivePractice {

    public static void main(String[] args) {
        Trader cris = new Trader("cris", "北京");
        Trader james = new Trader("james", "LA");
        Trader harden = new Trader("harden", "上海");
        Trader curry = new Trader("curry", "LA");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(cris, 2012, 300),
                new Transaction(james, 2011, 500),
                new Transaction(harden, 2016, 900),
                new Transaction(curry, 2009, 700),
                new Transaction(cris, 2011, 800),
                new Transaction(james, 2018, 888));

        // 1. 找出所有2011年发生的交易，按照交易额排序（升序和降序）
//        Stream<Transaction> sorted = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue));
       /* Stream<Transaction> sorted = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue).reversed());
        sorted.forEach(System.out::println);*/

        // 2. 交易员都在哪些城市工作过
       /* Stream<String> distinct = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct();
        distinct.forEach(System.out::println);*/

        // 3. 查找所有来自LA的交易员，按照姓名排序
        /*Stream<Trader> la = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("LA")).distinct().sorted(Comparator.comparing(Trader::getName));
        la.forEach(System.out::println);*/

        // 4. 返回所有交易员的姓名字符串，按照字母排序
        /*Stream<String> sorted = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted(String::compareTo).reduce("", (x, y) -> x+y);
        sorted.forEach(System.out::println);*/

        // 5. 有没有交易员在上海工作？
        /*boolean 上海 = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("上海"));
        System.out.println(上海);*/
        // 5.1 从上海工作的交易员中拉一个人出来
   /*     Optional<Transaction> la = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("LA")).findAny();
        System.out.println(la.get().getTrader().getName());*/

        // 6. 打印所有生活在LA 的交易员的交易额
        /*Optional<Integer> la = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("LA")).map(Transaction::getValue).reduce(Integer::sum);
        System.out.println(la.get());*/

        // 7. 所有交易中最高的交易额是多少？
        /*Optional<Integer> reduce = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        Optional<Integer> integer = transactions.stream().max(Comparator.comparing(Transaction::getValue)).map(Transaction::getValue);
        System.out.println(reduce);*/

        // 8. 找到交易额最小的交易
        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(min.get());

    }

}
