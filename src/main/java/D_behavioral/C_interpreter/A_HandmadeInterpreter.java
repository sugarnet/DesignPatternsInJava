package D_behavioral.C_interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class A_HandmadeInterpreter {

    static List<Token> lex(String input) {
        ArrayList<Token> tokens = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+':
                    tokens.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '(':
                    tokens.add(new Token(Token.Type.LPARENT, "("));
                    break;
                case ')':
                    tokens.add(new Token(Token.Type.RPARENT, ")"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for (int j = i + 1; j < input.length(); j++) {
                        if (Character.isDigit(input.charAt(j))) {
                            sb.append(input.charAt(j));
                            i++;
                        } else {
                            tokens.add(new Token(Token.Type.INTEGER, sb.toString()));
                            break;
                        }
                    }
                    break;
            }
        }

        return tokens;
    }
    public static void main(String[] args) {
        String input = "(12+3)-(10-9)";
        List<Token> tokens = lex(input);

        System.out.println(tokens.stream().map(t -> t.toString())
                .collect(Collectors.joining("\t")));
    }
}

class Token {
    public enum Type {
        PLUS, MINUS, LPARENT, RPARENT, INTEGER
    }
    public Type type;
    public String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return "`" +text + "`";
    }
}



