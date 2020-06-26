package D_behavioral.J_strategy.A_dynamicstrategy;

import java.util.Arrays;
import java.util.List;

public class A_DynamicStrategy {
    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor(OutputFormat.MARKDOWN);
        tp.appendList(Arrays.asList("San Martín", "Belgrano", "Rosas"));
        System.out.println(tp);

        System.out.println();
        tp.clear();
        tp.setOutputFormat(OutputFormat.HTML);
        tp.appendList(Arrays.asList("Boca", "River", "Godoy Cruz"));
        System.out.println(tp);
    }
}

enum OutputFormat {
    MARKDOWN, HTML
}

interface ListStrategy {
    default void start(StringBuilder sb) {}
    void addListItem(StringBuilder sb, String item);
    default void end(StringBuilder sb) {}
}

class MarkdownListStrategy implements ListStrategy {
    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" * ").append(item).append(System.lineSeparator());
    }
}

class HtmlListStrategy implements ListStrategy {
    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append("  <li>").append(item).append("</li>").append(System.lineSeparator());

    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>").append(System.lineSeparator());

    }
}

class TextProcessor {
    private StringBuilder sb = new StringBuilder();
    private ListStrategy listStrategy;

    public TextProcessor(OutputFormat outputFormat) {
        setOutputFormat(outputFormat);
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        switch (outputFormat) {
            case HTML:
                listStrategy = new HtmlListStrategy();
                break;
            case MARKDOWN:
                listStrategy = new MarkdownListStrategy();
                break;
        }
    }

    public void appendList(List<String> items) {
        listStrategy.start(sb);
        for (String item : items) {
            listStrategy.addListItem(sb, item);
        }
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}