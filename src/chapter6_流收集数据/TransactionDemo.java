package chapter6_流收集数据;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName TransactionDemo
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TransactionDemo {

    // 将所有的交易按照货币名统计出来
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("RMB", 1000),
                new Transaction("RMB", 200),
                new Transaction("CRM", 450),
                new Transaction("CRM", 900));
        Map<String, List<Transaction>> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        List<Transaction> rmb = collect.get("RMB");
        rmb.forEach(System.out::println);

        // 以前的做法（遍历交易集合，判断map 中是否有当前交易的货币对应的list，如果有，添加当前交易；如果没有，创建list并put）
/*        Map<String, List<Transaction>> map = new HashMap<>();
        for (Transaction transaction : transactions) {

            String currency = transaction.getCurrency();
            List<Transaction> transactions1 = map.get(currency);

            if (transactions1 == null){
                List<Transaction> transactions2 = new ArrayList<>();
                transactions2.add(transaction);
                map.put(currency, transactions2);
            }else {
                transactions1.add(transaction);
            }
        }*/


    }

}
