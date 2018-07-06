package chapter8_重构_测试_调试;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ClassName FactoryMode
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class FactoryMode {

    public static void main(String[] args) {
        /*Car baoma = createProduct("baoma");
        System.out.println(baoma);*/
        Car benzi = createProduct1("benzi");
        System.out.println(benzi);
    }

    public static Car createProduct1(String s) {
        Map<String, Supplier<Car>> map = new HashMap<>();
        map.put("baoma", BaoMa::new);
        map.put("benzi", BenZi::new);
        map.put("falari", Falarri::new);
        return map.get(s).get();
    }

    public static Car createProduct(String s) {
        switch (s) {
            case "baoma":
                return new BaoMa();
            case "benzi":
                return new BenZi();
            case "falali":
                return new Falarri();

            default:
                return null;
        }
    }
}

class Car {
}

class BaoMa extends Car {
}

class BenZi extends Car {
}

class Falarri extends Car {
}
