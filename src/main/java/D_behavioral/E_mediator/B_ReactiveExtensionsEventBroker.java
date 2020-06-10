package D_behavioral.E_mediator;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.ArrayList;
import java.util.List;

/*
In this case the observable works as a Mediator. Because, maintains the connection between Player
and Coach without a specific relationship
 */

public class B_ReactiveExtensionsEventBroker {
    public static void main(String[] args) {
        EventBroker eventBroker = new EventBroker();
        FootballCoach footballCoach = new FootballCoach(eventBroker);
        FootballPlayer diego = new FootballPlayer(eventBroker, "Diego");

        diego.score();
        diego.score();
        diego.score();
    }
}

class EventBroker extends Observable<Integer> {

    private List<Observer<? super Integer>> observers = new ArrayList<>();

    @Override
    protected void subscribeActual(@NonNull Observer<? super Integer> observer) {
        observers.add(observer);
    }

    public void publish(int i) {
        for (Observer<? super Integer> observer : observers) {
            observer.onNext(i);
        }
    }
}

class FootballPlayer {
    private int goalsScored = 0;
    private EventBroker eventBroker;
    public String name;

    public FootballPlayer(EventBroker eventBroker, String name) {
        this.eventBroker = eventBroker;
        this.name = name;
    }

    public void score() {
        eventBroker.publish(++goalsScored);
    }
}

class FootballCoach {
    public FootballCoach(EventBroker eventBroker) {
        eventBroker.subscribe(i -> System.out.println("Hey, you scored " + i + " goals!"));
    }
}
