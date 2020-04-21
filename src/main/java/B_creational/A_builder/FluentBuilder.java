/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_creational.A_builder;

/**
 *
 * @author Almis
 */
public class FluentBuilder {
    public static void main(String[] args) {
        final Person person = new EmployeeBuilder().withName("Diego").
                worksAt("Developer").build();
        System.out.println(person);
    }
}

class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", position=" + position + '}';
    }
    
    
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();
    
    public SELF withName(String name) {
        person.name = name;
        return self();
    }
    
    public Person build() {
        return person;
    }
    
    public SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    
    public EmployeeBuilder worksAt(String ocupation) {
        person.position = ocupation;
        return self();
    }

    @Override
    public EmployeeBuilder self() {
        return this; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}