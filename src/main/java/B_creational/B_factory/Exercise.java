/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_creational.B_factory;

/**
 *
 * @author Almis
 */
class Person {

    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}

class PersonFactory {

    private static int COUNT_ID = 0;
    public Person createPerson(String name) {
        // todo
        return new Person(COUNT_ID++, name);
    }
}

public class Exercise {

    public static void main(String[] args) {
        final Person p1 = new PersonFactory().createPerson("Diego");
        System.out.println(p1);
        final Person p2 = new PersonFactory().createPerson("Pepe");
        System.out.println(p2);
        final Person p3 = new PersonFactory().createPerson("Carlos");
        System.out.println(p3);
    }
}
