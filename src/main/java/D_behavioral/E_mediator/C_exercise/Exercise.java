package D_behavioral.E_mediator.C_exercise;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        Participant p1 = new Participant(mediator);
        Participant p2 = new Participant(mediator);

        p1.say(3);
        p2.say(2);

        System.out.println("P1 " + p1.value);
        System.out.println("P2 " + p2.value);
    }
}

class Participant
{
    public int value;
    private Mediator mediator;

    public Participant(Mediator mediator)
    {
        this.value = 0;
        this.mediator = mediator;
        this.mediator.participants.add(this);
    }

    public void setValue(int value) {
        this.value += value;
    }

    public void say(int n)
    {
        mediator.broadcast(n, this);
    }
}

class Mediator
{
    public List<Participant> participants = new ArrayList<>();

    public void broadcast(int value, Participant participant) {
        participants.stream().filter(p -> p != participant).forEach(p -> p.setValue(value));
    }
}