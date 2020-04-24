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
public class StringBuilderTest {
    
    public static void main(String[] args) {
        /*String hello = "hello";
        System.out.println("<p>" + hello + "</p>");
        
        String [] words = {"hello", "world"};
        
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for(String word : words) {
            sb.append(String.format("  <li>%s</li>\n", word));
        }
        sb.append("</ul>");
        
        System.out.println(sb);*/
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello").addChild("li", "world");
        System.out.println(builder.toString());
    }
    
}

class HtmlElement {
    public String name, text;
    public List<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String toStringImpl(int indent) {
        
        StringBuilder sb = new StringBuilder();
        String i = String.join("", 
                Collections.nCopies(indent * indentSize, " "));
        
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if(text != null && !text.isEmpty()) {
            sb.append(String.join("", 
                Collections.nCopies(indentSize * (indent + 1), " ")))
                    .append(text)
                    .append(newLine);
        }
        
        for(HtmlElement e : elements) {
            sb.append(e.toStringImpl(indent + 1));
        }
        
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return toStringImpl(0);
    }
    
    
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }
    
    // not fluent
    /*public void addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
    }*/
    
    // fluent
    public HtmlBuilder addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.elements.add(e);
        return this;
    }
    
    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
    
    
}