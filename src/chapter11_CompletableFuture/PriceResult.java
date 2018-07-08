package chapter11_CompletableFuture;

/**
 * @ClassName PriceResult
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class PriceResult {

    private String shopName;
    private double price;
    private Discount.Code code;

    public PriceResult(String shopName, double price, Discount.Code code) {
        this.shopName = shopName;
        this.price = price;
        this.code = code;
    }

    public static PriceResult parse(String string) {
        if (string == null) {
            throw new RuntimeException("解析元素为null");
        }
        String[] split = string.split(":");
        return new PriceResult(split[0], Double.parseDouble(split[1]), Discount.Code.valueOf(split[2]));
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getCode() {
        return code;
    }
}
