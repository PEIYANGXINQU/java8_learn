package chapter10_optional取代null;

import java.util.Optional;

/**
 * @ClassName OptionalDemo
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        Person person = new Person();

    }

    public static String getEuranceName1(Optional<Person1> person1) {
        String string = person1.flatMap(Person1::getCar).flatMap(Car1::getEnsurance).map(Ensurance1::getName).orElse("unKonwn");
        return string;
    }
}

class Person1 {
    private Optional<Car1> car;

    public Optional<Car1> getCar() {
        return car;
    }

    public void setCar(Optional<Car1> car) {
        this.car = car;
    }
}

class Car1 {
    private Optional<Ensurance1> ensurance;

    public Optional<Ensurance1> getEnsurance() {
        return ensurance;
    }

    public void setEnsurance(Optional<Ensurance1> ensurance) {
        this.ensurance = ensurance;
    }
}

class Ensurance1 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
