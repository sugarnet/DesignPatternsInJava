package D_behavioral.B_command;

import java.util.Arrays;
import java.util.List;

public class A_Command {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);
        List<Command> commands = Arrays.asList(
                new BankAccountCommand(100, ba, BankAccountCommand.Action.DEPOSIT),
                new BankAccountCommand(1000, ba, BankAccountCommand.Action.WITHDRAW)
        );

        for (Command c : commands) {
            c.call();
            System.out.println(ba);
        }
    }
}

class BankAccount {
    private int balance;
    private int overdraftLimit = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", now the balance is " + balance);
    }

    public void withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", now the balance is " + balance);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

interface Command {
    void call();
}

class BankAccountCommand implements Command {
    private int amount;
    private BankAccount bankAccount;


    public enum Action {
        DEPOSIT, WITHDRAW
    }
    private Action action;

    public BankAccountCommand(int amount, BankAccount bankAccount, Action action) {
        this.amount = amount;
        this.bankAccount = bankAccount;
        this.action = action;
    }
    @Override
    public void call() {

        switch (action) {
            case DEPOSIT:
                bankAccount.deposit(amount);
                break;
            case WITHDRAW:
                bankAccount.withdraw(amount);
                break;
        }
    }
}
