package chapter6_流收集数据;

/**
 * @ClassName Transaction
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Transaction {

    // 交易货币
    private String currency;
    // 交易金额
    private Integer number;

    public Transaction(String currency, Integer number) {
        this.currency = currency;
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency='" + currency + '\'' +
                ", number=" + number +
                '}';
    }
}
