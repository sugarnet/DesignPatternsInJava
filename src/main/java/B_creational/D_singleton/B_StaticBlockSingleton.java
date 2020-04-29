package B_creational.D_singleton;

import java.io.File;
import java.io.IOException;

public class B_StaticBlockSingleton {
}

class StaticBlokSingleton {

    private static StaticBlokSingleton instance;

    private StaticBlokSingleton() throws IOException {
        System.out.println("Singleton is initializing...");
        File.createTempFile(".", ".");
    }

    static {
        try {
            instance = new StaticBlokSingleton();
        } catch (IOException e) {
            System.err.println("Failed to create singleton");
        }
    }

    public static StaticBlokSingleton getInstance() {
        return instance;
    }
}
