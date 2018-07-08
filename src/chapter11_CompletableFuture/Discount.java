package chapter11_CompletableFuture;

/**
 * @ClassName Discount
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Discount {

    public static String applyDiscount(PriceResult priceResult) {
        return priceResult.getShopName() + ", price is " + apply(priceResult);
    }

    public static double apply(PriceResult priceResult) {
        // 模拟服务延迟
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return priceResult.getPrice() * (100 - priceResult.getCode().percentage);
    }

    /*枚举定义折扣*/
    public enum Code {
        NONE(0), NORMAL(10), GOOD(20), GREAT(30), CREAZY(50);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }
}
