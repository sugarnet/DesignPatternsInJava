/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_creational.C_prototype;

import java.util.Arrays;

/**
 *
 * @author Almis
 */
public class A_DoNotUseCloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        final Person diego = new Person(new String[]{"Diego", "Scifo"}, 
                new Address("Remedios Escalada", 370));
        Person sol = (Person) diego.clone();
        sol.names[0] = "Sol";
        sol.names[1] = "Mauna";
        sol.address.streetName = "Remedios Escalada de San Martín";
        
        System.out.println(diego);
        System.out.println(sol);
    }
}

class Address implements Cloneable{
    public String streetName;
    public int numberHouse;

    public Address(String streetName, int numberHouse) {
        this.streetName = streetName;
        this.numberHouse = numberHouse;
    }

    @Override
    public String toString() {
        return "Address{" + "streetName=" + streetName + ", numberHouse=" 
                + numberHouse + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Address(streetName, numberHouse);
    }
}

class Person implements Cloneable {
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "names=" + Arrays.toString(names)
                + ", address=" + address + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(names.clone(), (Address) address.clone());
    }
}
