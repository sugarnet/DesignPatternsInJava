package D_behavioral.C_interpreter.B_exercise;

import java.util.HashMap;
import java.util.Map;

public class Exercise {
    public static void main(String[] args) {
        String input = "13+4-12+x";
        ExpressionProcessor ep = new ExpressionProcessor();
        ep.variables.put('x', 5);
        System.out.println(ep.calculate(input));
    }
}

class ExpressionProcessor
{
    public Map<Character, Integer> variables = new HashMap<>();

    enum NextOp
    {
        NOTHING, PLUS, MINUS
    }

    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int calculate(String expression)
    {
        int current = 0;
        NextOp nextOp = NextOp.NOTHING;

        String[] parts = expression.split("(?<=[+-])");

        for (String part : parts)
        {
            String[] noOp = part.split("[+-]");
            String first = noOp[0];
            int value;

            Integer z = tryParse(first);
            if (z != null)
            {
                value = z.intValue();
            } else if (first.length() == 1
                    && variables.containsKey(first.charAt(0)))
            {
                value = variables.get(first.charAt(0));
            }
            else return 0;

            switch (nextOp)
            {
                case NOTHING:
                    current = value;
                    break;
                case PLUS:
                    current += value;
                    break;
                case MINUS:
                    current -= value;
                    break;
            }

            if (part.endsWith("+")) nextOp = NextOp.PLUS;
            else if (part.endsWith("-")) nextOp = NextOp.MINUS;
        }
        return current;
    }
}