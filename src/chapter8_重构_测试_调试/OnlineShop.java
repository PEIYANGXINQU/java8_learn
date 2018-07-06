package chapter8_重构_测试_调试;

interface DisCount<T> {
    void discount(T t);
}

/**
 * @ClassName OnlineShop
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public abstract class OnlineShop {

    public void vipCustomer(Customer customer, DisCount<Customer> disCount) {
        // 这里有校验用户是否是vip的方法等

        disCount.discount(customer);
    }

    // 为vip用户准备的打折优惠
//    abstract void discount(Customer customer);

}

class Customer {
}

class OnlineShopB extends OnlineShop {

    public static void main(String[] args) {
        OnlineShop onlineShopB = new OnlineShopB();
        onlineShopB.vipCustomer(new Customer(), customer -> System.out.println("打三折"));
    }
}

/*class OnlineShopA extends OnlineShop{

    @Override
    void discount(Customer customer) {
        System.out.println("打五折");
    }

    public static void main(String[] args) {
        OnlineShop onlineShopA = new OnlineShopA();
        onlineShopA.vipCustomer(new Customer());
    }
}*/
