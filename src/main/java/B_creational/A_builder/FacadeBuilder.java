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
public class FacadeBuilder {
    public static void main(String[] args) {
        NormalPersonBuilder npb = new NormalPersonBuilder();
        NormalPerson person = npb
                .lives()
                    .at("RE de San Martín 370")
                    .withPostCode("5511")
                    .in("General Gutiérrez")
                .works()
                    .at("Globallogic")
                    .asA("Developer")
                    .income(1234)
                .build();
        
        System.out.println(person);
    }
}

class NormalPerson {
    public String addressStreet, postCode, city;
    
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "NormalPerson{" + "addressStreet=" + addressStreet 
                + ", postCode=" + postCode + ", city=" + city + ", companyName=" 
                + companyName + ", position=" + position + ", annualIncome=" 
                + annualIncome + '}';
    }
}

class NormalPersonBuilder {
    
    protected NormalPerson person = new NormalPerson();
    
    public NormalPersonAddressBuilder lives() {
        return new NormalPersonAddressBuilder(person);
    }
    
    public NormalPersonEmploymentBuilder works() {
        return new NormalPersonEmploymentBuilder(person);
    }
    
    public NormalPerson build() {
        return person;
    }
    
}

class NormalPersonAddressBuilder extends NormalPersonBuilder {

    public NormalPersonAddressBuilder(NormalPerson person) {
        this.person = person;
    }
    
    public NormalPersonAddressBuilder at(String addressStreet) {
        person.addressStreet = addressStreet;
        return this;
    }
    
    public NormalPersonAddressBuilder withPostCode(String postCode) {
        person.postCode = postCode;
        return this;
    }
    
    public NormalPersonAddressBuilder in(String city) {
        person.city = city;
        return this;
    }
    
}

class NormalPersonEmploymentBuilder extends NormalPersonBuilder {

    public NormalPersonEmploymentBuilder(NormalPerson person) {
        this.person = person;
    }
    
    public NormalPersonEmploymentBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }
    
    public NormalPersonEmploymentBuilder asA(String position) {
        person.position = position;
        return this;
    }
    
    public NormalPersonEmploymentBuilder income(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }
    
}
