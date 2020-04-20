/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.builder;

/**
 *
 * @author Almis
 */
public class StringBuilderTest {
    
    public static void main(String[] args) {
        String hello = "hello";
        System.out.println("<p>" + hello + "</p>");
        
        String [] words = {"hello", "world"};
        
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for(String word : words) {
            sb.append(String.format("  <li>%s</li>\n", word));
        }
        sb.append("</ul>");
        
        System.out.println(sb);
    }
    
}
