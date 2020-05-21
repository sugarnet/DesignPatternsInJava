package C_structural.F_flyweight;

import java.util.ArrayList;
import java.util.List;

public class C_Exercise {
    public static void main(String[] args) {
        Sentence s = new Sentence("hello world");
        s.getWord(1).capitalize = true;
        System.out.println(s);
    }
}

class Sentence
{
    private String plainText;
    List<WordToken> formatting = new ArrayList<>();

    public Sentence(String plainText)
    {
        this.plainText = plainText;
    }

    public WordToken getWord(int index)
    {
        WordToken wt = new WordToken(index);
        formatting.add(wt);
        return wt;
    }

    @Override
    public String toString()
    {
        String [] words = plainText.split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (WordToken wt : formatting) {
                result.add(wt.isTheWord(i) && wt.capitalize ? words[i].toUpperCase() : words[i]);
            }
        }
        return String.join(" ", result);
    }

    class WordToken
    {
        public boolean capitalize;
        public int position;

        public WordToken(int position) {
            this.position = position;
        }

        public boolean isTheWord(int idx) {
            return position == idx;
        }
    }
}