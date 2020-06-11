package D_behavioral.F_memento.B_exercise;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
}

class Token {
    public int value = 0;

    public Token(int value) {
        this.value = value;
    }
}

class Memento {
    public List<Token> tokens = new ArrayList<>();

    public Memento(List<Token> tokens) {
        this.tokens.addAll(tokens);
    }
}

class TokenMachine {
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value) {
        // todo
        tokens.add(new Token(value));
        return new Memento(tokens);
    }

    public Memento addToken(Token token) {
        // todo (yes, please do both overloads :)
        tokens.add(new Token(token.value));
        return new Memento(tokens);
    }

    public void revert(Memento m) {
        // todo
        this.tokens.clear();
        this.tokens.addAll(m.tokens);
    }
}