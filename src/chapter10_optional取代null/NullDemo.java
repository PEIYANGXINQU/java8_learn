package chapter10_optional取代null;

/**
 * @ClassName NullDemo
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class NullDemo {
    public static void main(String[] args) {

    }

    public static String getEnsuranceName2(Person person) {
        if (person == null) {
            return "person为null";
        }
        if (person.getCar() == null) {
            return "car is null";
        }
        if (person.getCar().getEnsurance() == null) {
            return "ensurance is null";
        }
        return person.getCar().getEnsurance().getName();
    }

    // 模拟获取用户的车的保险名（记住：不是每一个人都有车的,也不是每个人的车都有保险的）
    public static String getEnsuranceName(Person person) {
        String name = "无保险";

        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Ensurance ensurance = car.getEnsurance();
                if (ensurance != null) {
                    name = ensurance.getName();
                }
            }
        }
        return name;
    }

}

class Person {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

class Car {
    private Ensurance ensurance;

    public Ensurance getEnsurance() {
        return ensurance;
    }

    public void setEnsurance(Ensurance ensurance) {
        this.ensurance = ensurance;
    }
}

class Ensurance {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}