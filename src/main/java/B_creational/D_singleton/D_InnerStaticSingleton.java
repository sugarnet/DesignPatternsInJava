package B_creational.D_singleton;

public class D_InnerStaticSingleton {
    public static void main(String[] args) {
        InnerStaticSingleton instance = InnerStaticSingleton.getInstance();
        System.out.println(instance);
    }
}

class InnerStaticSingleton {
    private InnerStaticSingleton(){}

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}
