package D_behavioral.H_observer.C_exercise;

import org.junit.Test;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.Assert.assertEquals;

public class Exercise  {
    @Test
    public void singleRatTest()
    {
        Game game = new Game();
        Rat rat = new Rat(game);
        assertEquals(1, rat.attack);
    }

    @Test
    public void twoRatTest()
    {
        Game game = new Game();
        Rat rat = new Rat(game);
        Rat rat2 = new Rat(game);
        assertEquals(2, rat.attack);
        assertEquals(2, rat2.attack);
    }

    @Test
    public void threeRatsOneDies()
            throws IOException
    {
        Game game = new Game();

        Rat rat = new Rat(game);
        assertEquals(1, rat.attack);

        Rat rat2 = new Rat(game);
        assertEquals(2, rat.attack);
        assertEquals(2, rat2.attack);

        try (Rat rat3 = new Rat(game))
        {
            assertEquals(3, rat.attack);
            assertEquals(3, rat2.attack);
            assertEquals(3, rat3.attack);
        }

        assertEquals(2, rat.attack);
        assertEquals(2, rat2.attack);
    }
}

/*class Game
{
    public List<Rat> rats = new ArrayList<>();

    public Game() {
    }
}

class Rat implements Closeable
{
    private Game game;
    public static int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        this.game.rats.add(this);
        attack = this.game.rats.size();
    }

    @Override
    public void close() throws IOException
    {
        this.game.rats.remove(0);
        attack = this.game.rats.size();
    }
}*/

class Event<T> {
    private List<BiConsumer<Object, T>> consumers = new ArrayList<>();

    public void subscribe(BiConsumer<Object, T> consumer)
    {
        consumers.add(consumer);
    }

    public void invoke(Object sender, T arg)
    {
        for (BiConsumer<Object, T> consumer : consumers)
            consumer.accept(sender, arg);
    }
}

class Game
{
    public Event<Void> ratEnters = new Event<>();
    public Event<Void> ratDies = new Event<>();
    public Event<Rat> notifyRat = new Event<>();
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        game.ratEnters.subscribe((sender, arg) -> {
            if (sender != this)
            {
                ++attack;
                game.notifyRat.invoke(this, (Rat) sender);
            }
        });
        game.notifyRat.subscribe((sender, rat) -> {
            if (rat == this) ++attack;
        });
        game.ratDies.subscribe((sender, arg) -> --attack);
        game.ratEnters.invoke(this, null);
    }

    @Override
    public void close() throws IOException
    {
        // rat dies ;(
        game.ratDies.invoke(this, null);
    }
}