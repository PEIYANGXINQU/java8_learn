package chapter8_重构_测试_调试;

import java.util.ArrayList;
import java.util.List;

// 观察者
@FunctionalInterface
interface Observer {
    void accept(String string);
}

// 主题
interface Subject {
    void register(Observer observer);

    void publish(String string);
}

/**
 * @ClassName ObserverMode
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class ObserverMode {

    public static void main(String[] args) {
        Subject subject = new XiaoMi();
        subject.register(string -> System.out.println("天猫收到信息了：" + string));
        subject.register(string -> System.out.println("京东收到信息了：" + string));
        subject.publish("小米手机大促销，不要钱了！");
    }

}

class TianMao implements Observer {

    @Override
    public void accept(String string) {
        System.out.println("天猫收到信息了：" + string);
    }
}

class JingDong implements Observer {

    @Override
    public void accept(String string) {
        System.out.println("京东收到信息了：" + string);
    }
}

class XiaoMi implements Subject {

    List<Observer> list = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        list.add(observer);
    }

    @Override
    public void publish(String string) {
        list.forEach(observer -> observer.accept(string));
    }
}
