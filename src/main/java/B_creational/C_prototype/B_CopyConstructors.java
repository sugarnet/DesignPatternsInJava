package B_creational.C_prototype;

public class B_CopyConstructors {
    public static void main(String[] args) {
        Employee john = new Employee("John",
                new AddressCC("Remedios Escalada", "Gral Gutiérrez", "Arg"));

        Employee jake = new Employee(john);

        jake.name = "Jake";
        System.out.println(john);
        System.out.println(jake);
    }
}

class AddressCC {
    public String streetName, city, country;

    public AddressCC(String streetName, String city, String country) {
        this.streetName = streetName;
        this.city = city;
        this.country = country;
    }

    // copy constructor
    public AddressCC(AddressCC other) {
        this(other.streetName, other.city, other.country);
    }

    @Override
    public String toString() {
        return "AddressCC{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {
    public String name;
    public AddressCC addressCC;

    public Employee(String name, AddressCC addressCC) {
        this.name = name;
        this.addressCC = addressCC;
    }

    public Employee(Employee other) {
        name = other.name;
        addressCC = new AddressCC(other.addressCC);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + addressCC +
                '}';
    }
}