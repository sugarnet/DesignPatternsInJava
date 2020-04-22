/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_creational.A_builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Almis
 */
public class Exercise {
    
}

class CodeBuilder {
    private String className;
    private CodeElement codeElement = new CodeElement();
    
    public CodeBuilder(String className)
    {
        // todo
    }
    
    public CodeBuilder addField(String name, String type)
    {
        // todo
    }
    
    @Override
    public String toString()
    {
        // todo
    }
}

class ChunkCode {
    public NameClassElement classElement;
}

class NameClassElement {
    public String className;
    public List<FieldClassElement> fields = new ArrayList<>();

    public NameClassElement(String className) {
        this.className = className;
    }
    
    
    

    @Override
    public String toString() {
        return "NameClassElement{" + '}';
    }
    
    
}

class FieldClassElement {
    
    public String type, name;

    public FieldClassElement(String type, String name) {
        this.type = type;
        this.name = name;
    }
    
    
    
}
