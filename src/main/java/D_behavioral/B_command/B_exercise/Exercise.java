package D_behavioral.B_command.B_exercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class Exercise {
    @Test
    public void test()
    {
        Account a = new Account();

        Command command = new Command(Command.Action.DEPOSIT, 100);
        a.process(command);

        assertEquals(100, a.balance);
        assertTrue(command.success);

        command = new Command(Command.Action.WITHDRAW, 50);
        a.process(command);

        assertEquals(50, a.balance);
        assertTrue(command.success);

        command = new Command(Command.Action.WITHDRAW, 150);
        a.process(command);

        assertEquals(50, a.balance);
        assertFalse(command.success);
    }
}

class Command {
    enum Action {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public Command(Action action, int amount) {
        this.action = action;
        this.amount = amount;
    }
}

class Account {
    public int balance;

    public void process(Command c) {
        switch (c.action) {
            case DEPOSIT:
                balance += c.amount;
                c.success = true;
                break;

            case WITHDRAW:
                if (balance >= c.amount) {
                   balance -= c.amount;
                   c.success = true;
                } else {
                   c.success = false;
                }
                break;
        }
    }
}