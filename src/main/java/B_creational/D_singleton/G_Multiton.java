package B_creational.D_singleton;

import java.util.HashMap;

public class G_Multiton {
    public static void main(String[] args) {
        Printer primary = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
    }
}

enum Subsystem {
    PRIMARY, AUXILIARY, FALLBACK;
}

class Printer {

    private static HashMap<Subsystem, Printer> instances = new HashMap<>();
    private static int countInstancesCreated = 0;

    private Printer(){
        countInstancesCreated++;
        System.out.println("The total number of instances created:" + countInstancesCreated);
    }

    public static Printer get(Subsystem ss) {
        if (instances.containsKey(ss)) {
            return instances.get(ss);
        }

        Printer printer = new Printer();
        instances.put(ss, printer);
        return printer;
    }
}
