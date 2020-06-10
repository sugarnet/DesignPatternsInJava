package D_behavioral.D_iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class B_ArrayBackedProperties {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(19);
        creature.setStrength(21);
        creature.setIntelligence(15);

        System.out.println("The sum stat is: " + creature.sum()
        + ", the max stat is " + creature.max()
        + " the average is " + creature.average());
    }
}

class SimpleCreature {
    private int strength, agility, intelligence;

    public int max() {
        return Math.max(strength, Math.max(agility, intelligence));
    }

    public int sum() {
        return strength + agility + intelligence;
    }

    public double average() {
        return sum() / 3.0;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

class Creature implements Iterable<Integer> {
    private int [] stats = new int[3];

    private static final int IDX_STRENGTH = 0;
    private static final int IDX_AGILITY = 1;
    private static final int IDX_INTELLIGENCE = 2;

    public int sum() {
        return IntStream.of(stats).sum();
    }
    public double average() {
        return IntStream.of(stats).average().getAsDouble();
    }
    public double max() {
        return IntStream.of(stats).max().getAsInt();
    }

    public int getStrength() {
        return stats[IDX_STRENGTH];
    }

    public void setStrength(int value) {
        stats[IDX_STRENGTH] = value;
    }
    public int getAgility() {
        return stats[IDX_AGILITY];
    }

    public void setAgility(int value) {
        stats[IDX_AGILITY] = value;
    }
    public int getIntelligence() {
        return stats[IDX_INTELLIGENCE];
    }

    public void setIntelligence(int value) {
        stats[IDX_INTELLIGENCE] = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return IntStream.of(stats).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> consumer) {
        for (int stat : stats) {
            consumer.accept(stat);
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return IntStream.of(stats).spliterator();
    }
}