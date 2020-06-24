package D_behavioral.I_state.A_classicimplementation;

public class A_ClassicImplementation {
    public static void main(String[] args) {
        LightSwitch ls = new LightSwitch();
        ls.on();
        ls.off();
        ls.off();
    }
}

class State {
    public void on(LightSwitch ls) {
        System.out.println("Light is already on");
    }
    public void off(LightSwitch ls) {
        System.out.println("Light is already off");

    }
}

class OnState extends State {
    public OnState() {
        System.out.println("Light turned on");
    }

    @Override
    public void off(LightSwitch ls) {
        System.out.println("Switching light off...");
        ls.setState(new OffState());
    }
}

class OffState extends State {
    public OffState() {
        System.out.println("Light turned off");
    }

    @Override
    public void on(LightSwitch ls) {
        System.out.println("Switching light on...");
        ls.setState(new OnState());
    }
}

class LightSwitch {
    private State state;

    public LightSwitch() {
        this.state = new OffState();
    }

    public void setState(State state) {
        this.state = state;
    }

    void on() {
        state.on(this);
    }
    void off() {
        state.off(this);
    }
}
