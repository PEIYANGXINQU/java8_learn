package chapter11_CompletableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @ClassName Shop
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public static double calculatePrice(String productName) {
        //查询数据库，或者联系商品供应商确定折扣等服务我们这里使用delay方法模拟
        delay();
        return new Random().nextDouble() * productName.charAt(0) + productName.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*测试异步处理的基准：在异步处理的过程中，调用方可以继续干其他事*/
    public static void main(String[] args) {
        Shop shop = new Shop("亚马逊");
        long start = System.currentTimeMillis();
        Future<Double> bread = shop.getProductPriceOptimizedAsync("bread");
        System.out.println(System.currentTimeMillis() - start);
        try {
            Double aDouble = bread.get();
            System.out.println(aDouble);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public String getName() {
        return name;
    }

    /*更加简洁的异步查询*/
    public Future<Double> getProductPriceOptimizedAsync(String productName) {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> calculatePrice(productName));
        return completableFuture;       // 这个completableFutrure 和下面的完全等价（换句话说，我们不用再去手动捕获异常了以及开启线程了）
    }

    /*异步查询 */
    public Future<Double> getProductPriceAsync(String productName) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            // 如果价格计算失败，一定要抛出异常（这里是将异常包裹在completableFuture对象中，防止调用方一直堵塞并且明白到底
            // 什么原因导致了异常）
            try {
                double productPrice = calculatePrice(productName);
                completableFuture.complete(productPrice);
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        }).start();
        return completableFuture;
    }

    /*根据商品名字查询价格（添加折扣后的同步方法模式）*/
    public String getProductPrice(String productName) {
        // 返回指定商品的价格
        Random random = new Random();
        double v = calculatePrice(productName);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, v, code);
    }
}
