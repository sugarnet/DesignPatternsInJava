package C_structural.G_proxy;

public class A_ProtectionProxy {
    public static void main(String[] args) {
        Car car = new CarProxy(new Driver(12));
        car.drive();
    }
}

interface Drivable {
    void drive();
}

class Car implements Drivable {
    protected Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.println("Car being driven");
    }
}

class Driver {
    public int age;

    public Driver(int age) {
        this.age = age;
    }
}

/*
The proxy in this case check the age of driver. Giving me a control layer over the Driver
in the Car class.
In this case CarProxy extends of Car, therefore CarProxy is a Car, so, CarProxy has the same
behavior.
 */
class CarProxy extends Car {

    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        if (driver.age >= 18) {
            super.drive();
        } else {
            System.out.println("Driver too young!");
        }
    }
}