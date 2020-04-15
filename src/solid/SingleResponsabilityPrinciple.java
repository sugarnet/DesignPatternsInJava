/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class SingleResponsabilityPrinciple {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        
        System.out.println(j);
        
        Persintence p = new Persintence();
        String filename = "c:\\tmp\\journal.txt";
        p.saveToFile(j, filename, Boolean.TRUE);
        
        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;
    
    public void addEntry(String text) {
        entries.add("" + count++ + ": " + text);
    }
    
    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

}

class Persintence {
    public void saveToFile(Journal journal, String filename, Boolean overwrite) 
            throws FileNotFoundException {
        
        if( overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
        
    }
    

}