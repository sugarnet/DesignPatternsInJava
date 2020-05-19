package C_structural.D_decorator;

public class E_Exercise {
}

class Bird {
    public int age;

    public String fly() {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard {
    public int age;

    public String crawl() {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon {
    private Lizard lizard;
    private Bird bird;
    private int age;

    public Dragon() {
        this.lizard = new Lizard();
        this.bird = new Bird();
    }

    public void setAge(int age) {
        this.age = age;
        this.lizard.age = age;
        this.bird.age = age;
    }

    public String fly() {
        return bird.fly();
    }

    public String crawl() {
        return lizard.crawl();
    }
}