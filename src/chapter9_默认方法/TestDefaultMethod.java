package chapter9_默认方法;

interface Car {
    default void run() {
        System.out.println("可以在陆地奔驰");
    }
}

interface ThreeWheelCar extends Car {
    default void run() {
        System.out.println("三轮车在奔跑");
    }
}

interface FourWheelCar extends Car {
    default void run() {
        System.out.println("四轮车在飞驰");
    }
}

/**
 * @ClassName TestDefaultMethod
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestDefaultMethod {
    public static void main(String[] args) {
        BaoMa baoMa = new BaoMa();
        baoMa.run();
    }

}

class BaoMa implements ThreeWheelCar, FourWheelCar {

    @Override
    public void run() {
        ThreeWheelCar.super.run();
    }
}
