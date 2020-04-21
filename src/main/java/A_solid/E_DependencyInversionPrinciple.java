/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_solid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.javatuples.Triplet;

/**
 *
 * @author Almis
 */
public class E_DependencyInversionPrinciple {
    public static void main(String[] args) {
        final Person parent = new Person("John");
        final Person child1 = new Person("Harry");
        final Person child2 = new Person("Matt");
        
        final Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);
        
        final Research research = new Research(relationships);
        
    }
}

enum Relationship {
    PARENT, CHILD, SIBLINGS
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
    
}

class Relationships implements RelationshipBrowser{ // low-level
    private List<Triplet<Person, Relationship, Person>> relations
            = new ArrayList<>();
    
    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    @Override
    public List<Person> findChildrenOf(String name) {
        return relations.stream().filter(r -> r.getValue0().name.equals(name) &&
                r.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }
    
}

interface RelationshipBrowser {
    List<Person> findChildrenOf(String name);
}

class Research { // high-level
//    public Research(Relationships relationships) {
//        final List<Triplet<Person, Relationship, Person>> relations 
//                = relationships.getRelations();
//        
//        relations.stream().filter(r -> r.getValue0().name.equals("John") &&
//                r.getValue1() == Relationship.PARENT)
//                .forEach(child -> System.out.println("John has a child called " 
//                        + child.getValue2().name));
//    }
    
    public Research(RelationshipBrowser relationships) {
        final List<Person> persons 
                = relationships.findChildrenOf("John");
        
        persons.stream().forEach(child -> System.out.println("John has a child called " 
                        + child.name));
    }
}
