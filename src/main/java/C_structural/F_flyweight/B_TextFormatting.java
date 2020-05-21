package C_structural.F_flyweight;

import java.util.ArrayList;
import java.util.List;

public class B_TextFormatting {
    public static void main(String[] args) {

        FormattedText ft = new FormattedText("This is my working morning");
        ft.capitalize(11, 17);
        System.out.println(ft);

        BetterFormattedText bft = new BetterFormattedText("Argentina is a great country");
        bft.getRange(21, 27).capitalize = true;
        System.out.println(bft);
    }
}

class FormattedText {
    private String plainText;
    private boolean [] capitalize;

    public FormattedText(String plainText) {
        this.plainText = plainText;
        this.capitalize = new boolean[plainText.length()];
    }

    public void capitalize(int start, int end) {
        for (int i = start; i <= end; i++) {
            this.capitalize[i] = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            sb.append(capitalize[i] ? Character.toUpperCase(c) : c);
        }
        return sb.toString();
    }
}

/*
In BetterFormattedText we are applying flyweight, because we are improve the memory use. We don't use
the boolean array.
 */
class BetterFormattedText {
    private String plainText;
    private List<TextRange> formatting = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange textRange = new TextRange(start, end);
        formatting.add(textRange);
        return textRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            for (TextRange tr : formatting) {
                if (tr.covers(i) && tr.capitalize) {
                    c = Character.toUpperCase(c);
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public class TextRange {
        public int start, end;
        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }
    }
}