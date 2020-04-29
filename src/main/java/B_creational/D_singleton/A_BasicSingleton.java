package B_creational.D_singleton;

import java.io.*;

public class A_BasicSingleton {

    public static void main(String[] args) throws Exception {
        /**
         * BasicSingleton instance = BasicSingleton.getInstance();
         * BasicSingleton instance2 = BasicSingleton.getInstance();
         * BasicSingleton instance3 = BasicSingleton.getInstance();
         * instance.setValue(124);
         * System.out.println(instance);
         * System.out.println(instance.getValue());
         * instance.setValue(125);
         * System.out.println(instance2);
         * System.out.println(instance2.getValue());
         * instance.setValue(126);
         * System.out.println(instance3);
         * System.out.println(instance3.getValue());
        */

        /**
         * Problems with Basic Singleton
         * 1. Reflection
         * 2. Serialization
         */

        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        String filename = "singleton.bin";
        saveToFile(singleton, filename);
        singleton.setValue(222);

        BasicSingleton singleton2 = readFromFile(filename);

        System.out.println(singleton == singleton2);

        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());

    }

    static void saveToFile(BasicSingleton singleton, String filename) throws Exception {

        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String filename) throws Exception {
        try(FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }

}

class BasicSingleton implements Serializable {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private int value = 0;

    private BasicSingleton(){}

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // we put this method for resolve serialization problem
    protected Object readResolve() {
        return INSTANCE;
    }
}
