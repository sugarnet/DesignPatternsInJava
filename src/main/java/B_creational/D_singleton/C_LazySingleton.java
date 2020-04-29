package B_creational.D_singleton;

public class C_LazySingleton {
}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing a lazy singleton...");
    }

    /*private synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }*/

    // double-checked locking
    private LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
