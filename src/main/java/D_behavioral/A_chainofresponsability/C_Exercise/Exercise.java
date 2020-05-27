package D_behavioral.A_chainofresponsability.C_Exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Exercise {
    @Test
    public void manyGoblinsTest()
    {
        Game game = new Game();
        Goblin goblin = new Goblin(game);
        game.creatures.add(goblin);

        assertEquals(1, goblin.getAttack());
        assertEquals(1, goblin.getDefense());

        Goblin goblin2 = new Goblin(game);
        game.creatures.add(goblin2);

        assertEquals(1, goblin.getAttack());
        assertEquals(2, goblin.getDefense());

        GoblinKing goblin3 = new GoblinKing(game);
        game.creatures.add(goblin3);

        assertEquals(2, goblin.getAttack());
        assertEquals(3, goblin.getDefense());
    }
}

abstract class Creature {
    protected Game game;
    protected int defense;
    protected int attack;

    public Creature(Game game, int attack, int defense) {
        this.game = game;
        this.attack = attack;
        this.defense = defense;
    }

    public abstract int getAttack();
    public abstract int getDefense();
    public abstract void query(Object source, StatQuery sq);
}

class Goblin extends Creature {
    public Goblin(Game game, int attack, int defense) {
        super(game, attack, defense);
    }

    public Goblin(Game game) {
        super(game, 1, 1);
    }

    @Override
    public int getAttack() {
        StatQuery sq = new StatQuery(Statistic.ATTACK);
        for (Creature c : game.creatures) {
            c.query(this, sq);
        }

        return sq.result;
    }

    @Override
    public int getDefense()
    {
        StatQuery sq = new StatQuery(Statistic.DEFENSE);
        for (Creature c : game.creatures) {
            c.query(this, sq);
        }

        return sq.result;
    }

    @Override
    public void query(Object source, StatQuery sq) {

        if (source == this) {
            switch (sq.statistic) {
                case ATTACK:
                    sq.result += attack;
                break;
                case DEFENSE:
                    sq.result += defense;
                break;
            }
        } else if (sq.statistic == Statistic.DEFENSE) {
            sq.result++;
        }
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        super(game, 3, 3);
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source != this && sq.statistic == Statistic.ATTACK) {
            sq.result++;
        } else {
            super.query(source, sq);
        }
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();
}

class StatQuery {
    public int result;
    public Statistic statistic;

    public StatQuery(Statistic statistic) {
        this.statistic = statistic;
    }
}