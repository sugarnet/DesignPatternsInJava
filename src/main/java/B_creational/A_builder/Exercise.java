/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_creational.A_builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author Almis
 */
public class Exercise {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person");
        // cb.addField("name", "String").addField("age", "int");
        
        System.out.println(cb.toString());
    }
}

class CodeBuilder {
    private ClassElement classElement = new ClassElement();
    
    public CodeBuilder(String className)
    {
        this.classElement.className = className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
        FieldClassElement fce = new FieldClassElement(type, name);
        this.classElement.fields.add(fce);
        return this;
    }
    
    @Override
    public String toString()
    {
        return this.classElement.toString();
    }
}

class ClassElement {
    public String className;
    public List<FieldClassElement> fields = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public ClassElement(){}
    
    public ClassElement(String className) {
        this.className = className;
    }
    
    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("public class %s%s{", className, newLine));
        
        List<FieldClassElement> filteredFields = fields.stream()
            .filter(f ->  Objects.nonNull(f.name) 
                    && Objects.nonNull(f.type) 
                    && !f.name.isEmpty() 
                    && !f.type.isEmpty())
            .collect(Collectors.toList());
        
        sb.append(String.format("%s", newLine));
        
        if(!filteredFields.isEmpty()) {
            filteredFields.forEach( f -> {

                    sb.append(String.join("", 
                    Collections.nCopies(indentSize * (indent + 1), " ")))
                        .append(String.format("public %s %s;", f.type, f.name))
                        .append(newLine);

            });
        } 
        sb.append(String.format("}"));
        
        
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return toStringImpl(0);
    }
    
    
}

class FieldClassElement {
    
    public String type, name;

    public FieldClassElement(String type, String name) {
        this.type = type;
        this.name = name;
    }
    
}
