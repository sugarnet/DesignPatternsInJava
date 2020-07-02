package D_behavioral.K_template;

public class A_TemplateMethod {
    public static void main(String[] args) {
        new Chess().run();
    }
}

abstract class Game {
    protected int currentPlayer;
    protected final int numberOfPlayers;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void run() {
        start();
        while(!haveWinner()) {
            takeTurn();
        }
        System.out.println("Player " + getWinningPlayer() + " wins");
    }

    protected abstract int getWinningPlayer();
    protected abstract boolean haveWinner();
    protected abstract void start();
    protected abstract void takeTurn();

}

class Chess extends Game {

    private int turn = 1;
    private int maxTurn = 10;

    public Chess() {
        super(2);
    }

    @Override
    protected int getWinningPlayer() {
        return 0;
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurn;
    }

    @Override
    protected void start() {
        System.out.println("Starting a game of chess");
    }

    @Override
    protected void takeTurn() {
        System.out.println("Turn " + (turn++) + " take by player " + currentPlayer);
        currentPlayer = (currentPlayer+1) % numberOfPlayers;
    }
}