package D_behavioral.G_nullobject;

import java.lang.reflect.Proxy;

public class A_NullObject {

    /*
        We use this proxy method for using Null Object. It's more elegant than build a class
        which doesn't do nothing.
     */
    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?> [] {itf},
                ((proxy, method, args) -> {
                    if (method.getReturnType().equals(Void.TYPE)) {
                        return null;
                    } else {
                        return method.getReturnType().getConstructor().newInstance();
                    }
                })
        );
    }

    public static void main(String[] args) {
        // NullLog log = new NullLog();
        // ConsoleLog log = new ConsoleLog();
        Log log = noOp(Log.class);
        BankAccount account = new BankAccount(log);

        account.deposit(300);
    }
}

interface Log {
    void info(String msg);
    void warn(String msg);
}

class ConsoleLog implements Log {
    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARNING: " + msg);
    }
}

final class NullLog implements Log {
    @Override
    public void info(String msg) {

    }

    @Override
    public void warn(String msg) {

    }
}

class BankAccount {
    private final Log log;
    private int balance;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;

        log.info("Deposited: " + amount);
    }
}