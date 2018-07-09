package chapter11_CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName ShopPriceDemo
 * @Description 最佳商品价格查询器
 * @Author zc-cris
 * @Version 1.0
 **/
public class BestPriceFinder {

    // 自定义最佳线程池来优化异步操作的效率
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(100, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
/*        Shop shop = new Shop();
        Future<Double> my_favorite_product = shop.getProductPriceOptimizedAsync("my favorite product");
        System.out.println("将异步任务交给另外的线程处理");
        // 模拟做其他事情
        Thread.sleep(1000);
        System.out.println("已经处理完其他事情");

        System.out.println("从future 中获取价格");
        Double price = my_favorite_product.get();
        System.out.println(price);*/

        // 使用并行流模拟从多家商店查询商品价格
        /*long start = System.nanoTime();
        List<Shop> shops = Arrays.asList(new Shop("京东"), new Shop("天猫"), new Shop("沃尔玛"));
        System.out.println(findPrice(shops,"iphone X"));
        System.out.println("消耗时间："+(System.nanoTime()-start)/1000000+"毫秒");*/

        // 使用异步方式模拟从多家商店查询价格
       /* long start = System.nanoTime();
        List<Shop> shops = Arrays.asList(new Shop("苏宁"),new Shop("淘宝"),new Shop("京东"), new Shop("天猫"), new Shop("沃尔玛"));
        System.out.println(findPriceByCompletableFuture(shops,"iphone X"));
        System.out.println("消耗时间："+(System.nanoTime()-start)/1000000+"毫秒");*/

        // 查看机器的核心数
//        System.out.println(Runtime.getRuntime().availableProcessors());

        // 使用同步方法查询折扣后的价格
        /*long start = System.nanoTime();
        List<Shop> shops = Arrays.asList(new Shop("苏宁"), new Shop("淘宝"), new Shop("京东"), new Shop("天猫"), new Shop("沃尔玛"));
        List<String> milk = shops.stream().map(shop -> shop.getProductPrice("milk")).map(PriceResult::parse).map(Discount::applyDiscount).collect(Collectors.toList());
        System.out.println(milk);
        System.out.println("消耗时间：" + (System.nanoTime() - start) / 1000000 + "毫秒");

        System.out.println("-------------------------");

        // 使用异步的方式查询折扣后的价格
        long l = System.nanoTime();
        List<Shop> shops1 = Arrays.asList(new Shop("苏宁"), new Shop("淘宝"), new Shop("京东"), new Shop("天猫"), new Shop("沃尔玛"));
        List<String> ball = findDiscountPriceByCompletableFuture(shops1, "ball");
        System.out.println(ball);
        System.out.println("消耗时间：" + (System.nanoTime() - l) / 1000000 + "毫秒");
*/

        //模拟真实场景的延时，实时展示每个异步处理的结果,最后所有结果计算完毕再汇总
        List<Shop> shops = Arrays.asList(new Shop("苏宁"), new Shop("淘宝"), new Shop("京东"), new Shop("天猫"), new Shop("沃尔玛"));
        long start = System.nanoTime();
        CompletableFuture[] books = findStream(shops, "book").map(f -> f.thenAccept(s -> System.out.println(s + "is done, use time " + (System.nanoTime() - start) / 1000000 + "毫秒"))).toArray(size -> new CompletableFuture[size]);
        Void join = CompletableFuture.allOf(books).join();
        System.out.println("所有优惠价格已经统计完毕：" + (System.nanoTime() - start) / 1000000 + "毫秒");
    }

    // 使用并行流根据商品名字从一系列的商店里查询该商品的价格，返回商店名及对应的价格
    public static List<String> findPrice(List<Shop> shops, String productName) {
        return shops.parallelStream().
                map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getProductPrice(productName)))
                .collect(Collectors.toList());
    }

    // 使用异步操作完成
    public static List<String> findPriceByCompletableFuture(List<Shop> shops, String productName) {

        List<CompletableFuture<String>> futures = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getProductPrice(productName)), EXECUTOR)).collect(Collectors.toList());

        return futures.stream().map(future -> future.join()).collect(Collectors.toList());

    }

    //使用多个异步操作完成流水线操作
    public static List<String> findDiscountPriceByCompletableFuture(List<Shop> shops, String productName) {

        List<CompletableFuture<String>> collect = shops.stream()
                //1. 第一步异步操作：从远程商店查询商品的原始价格以及对应的折扣
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getProductPrice(productName), EXECUTOR))
                //2. 这里可以使用同步操作，因为仅仅涉及到数据的转换
                .map(future -> future.thenApply(PriceResult::parse))
                //3. 第二个异步操作：向远程折扣服务传递指定数据并返回折扣后的价格
                .map(future -> future.thenCompose(priceResult -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(priceResult), EXECUTOR)))
                .collect(Collectors.toList());

        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static Stream<CompletableFuture> findStream(List<Shop> shops, String productName) {
        return
                shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getProductPrice(productName), EXECUTOR))
                        .map(f -> f.thenApply(PriceResult::parse))
                        .map(f -> f.thenCompose(priceResult -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(priceResult), EXECUTOR)));

    }

}