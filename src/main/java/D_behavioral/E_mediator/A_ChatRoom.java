package D_behavioral.E_mediator;

import java.util.ArrayList;
import java.util.List;

/*
The key here is that the Person hasn't a reference to other person. But the Person has a reference
to the mediator. The mediator maintains to people connected by a list and using the person methods
and the name of a person for identify them.
 */

public class A_ChatRoom {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();

        Person diego = new Person("Diego");
        Person alma = new Person("Alma");

        room.join(diego);
        room.join(alma);

        diego.say("Hola Alma");
        alma.say("Hola Papi");

        Person sol = new Person("Sol");
        room.join(sol);
        sol.say("Hola!!!");

        alma.privateMessage("Sol", "hola mami!");
    }
}

class Person {
    public String name;
    public ChatRoom room;
    public List<String> chatLog = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void receive(String sender, String message) {
        String s = sender + ": '" + message + "'";
        System.out.println("[" + name + "'s chat session] " + s);
        chatLog.add(s);
    }

    public void say(String message) {
        room.broadcast(name, message);
    }

    public void privateMessage(String who, String message) {
        room.message(name, who, message);
    }
}

class ChatRoom {

    private List<Person> people = new ArrayList<>();

    public void join(Person p) {
        String  joinMsg = p.name + " joins the room";
        broadcast("room", joinMsg);

        p.room = this;
        people.add(p);
    }

    public void broadcast(String source, String message) {
        for (Person p : people) {
            if (!p.name.equals(source)) {
                p.receive(source, message);
            }
        }
    }

    public void message(String source, String destination, String message) {
        people.stream().filter(p -> p.name.equals(destination))
                .findFirst()
                .ifPresent(person -> person.receive(source, message));
    }
}
