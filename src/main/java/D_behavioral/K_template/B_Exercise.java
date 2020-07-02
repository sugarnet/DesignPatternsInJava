package D_behavioral.K_template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class B_Exercise {
    @Test
    public void impasseTest()
    {
        Creature c1 = new Creature(1, 2);
        Creature c2 = new Creature(1, 2);
        TemporaryCardDamageGame game = new TemporaryCardDamageGame(new Creature[]{c1, c2});
        assertEquals(-1, game.combat(0,1));
        assertEquals(-1, game.combat(0,1));
    }

    @Test
    public void temporaryMurderTest()
    {
        Creature c1 = new Creature(1, 1);
        Creature c2 = new Creature(2, 2);
        TemporaryCardDamageGame game = new TemporaryCardDamageGame(new Creature[]{c1, c2});
        assertEquals(1, game.combat(0,1));
    }

    @Test
    public void doubleMurderTest()
    {
        Creature c1 = new Creature(2, 2);
        Creature c2 = new Creature(2, 2);
        TemporaryCardDamageGame game = new TemporaryCardDamageGame(new Creature[]{c1, c2});
        assertEquals(-1, game.combat(0,1));
    }

    @Test
    public void permanentDamageDeathTest()
    {
        Creature c1 = new Creature(1, 2);
        Creature c2 = new Creature(1, 3);
        CardGame game = new PermanentCardDamageGame(new Creature[]{c1, c2});
        assertEquals(-1, game.combat(0,1));
        assertEquals(1, game.combat(0,1));
    }
}

class Creature
{
    public int attack, health;

    public Creature(int attack, int health)
    {
        this.attack = attack;
        this.health = health;
    }
}

abstract class CardGame
{
    public Creature [] creatures;

    public CardGame(Creature[] creatures)
    {
        this.creatures = creatures;
    }

    // returns -1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2)
    {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        hit(second, first);

        // todo: determine who won and return either creature1 or creature2
        if ((first.health <= 0 && second.health <= 0)
                || (first.health > 0 && second.health > 0)) {
            return -1;
        } else if (first.health <= 0) {
            return creature2;
        } else {
            return creature1;
        }
    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame
{
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        // todo
        other.health -= attacker.attack;
        int oldHealth = other.health;

        if (other.health > 0) {
            other.health = oldHealth;
        }

    }
}

class PermanentCardDamageGame extends CardGame
{
    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        // todo
        other.health -= attacker.attack;
    }
}
