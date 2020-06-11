package D_behavioral.F_memento;

public class A_Memento {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(100);
        Memento m1 = ba.deposit(50);
        Memento m2 = ba.deposit(25);

        System.out.println(ba);

        System.out.println();
        System.out.println("Restoring...");

        // restore to m1
        ba.restore(m1);
        System.out.println(ba);

        // restore to m2
        ba.restore(m2);
        System.out.println(ba);

    }
}

class Memento {
    public int balance;

    public Memento(int balance) {
        this.balance = balance;
    }
}

class BankAccount {
    public int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public Memento deposit(int amount) {
        this.balance += amount;
        return new Memento(this.balance);
    }

    public void restore(Memento memento) {
        this.balance = memento.balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}
