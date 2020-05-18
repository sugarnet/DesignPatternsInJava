package C_structural.D_decorator;

import java.util.stream.IntStream;

/*
We can combine Decorator with other patterns. For example in this case we combine Decorator with
Adapter
 */
public class D_AdapterDecorator {
    public static void main(String[] args) {

        MyStringBuilder msb = new MyStringBuilder();
        msb.append("hello").appendLine(" world");
        System.out.println(msb.concat("and this too"));
    }
}

class MyStringBuilder {
    private StringBuilder sb;

    public MyStringBuilder() {
        this.sb = new StringBuilder();
    }

    public MyStringBuilder(String str) {
        this.sb = new StringBuilder(str);
    }

    public MyStringBuilder concat(String str) {
        return new MyStringBuilder(sb.toString().concat(str));
    }

    public MyStringBuilder appendLine(String str) {
        sb.append(str).append(System.lineSeparator());
        return this;
    }

    public String toString() {
        return sb.toString();
    }

    // delegate methods
    public StringBuilder append(Object o) {
        return sb.append(o);
    }

    // Problem: is not fluent. We need to do it
    public MyStringBuilder append(String s) {
        sb.append(s);
        return this;
    }

    public StringBuilder append(StringBuffer stringBuffer) {
        return sb.append(stringBuffer);
    }

    public StringBuilder append(CharSequence charSequence) {
        return sb.append(charSequence);
    }

    public StringBuilder append(CharSequence charSequence, int i, int i1) {
        return sb.append(charSequence, i, i1);
    }

    public StringBuilder append(char[] chars) {
        return sb.append(chars);
    }

    public StringBuilder append(char[] chars, int i, int i1) {
        return sb.append(chars, i, i1);
    }

    public StringBuilder append(boolean b) {
        return sb.append(b);
    }

    public StringBuilder append(char c) {
        return sb.append(c);
    }

    public StringBuilder append(int i) {
        return sb.append(i);
    }

    public StringBuilder append(long l) {
        return sb.append(l);
    }

    public StringBuilder append(float v) {
        return sb.append(v);
    }

    public StringBuilder append(double v) {
        return sb.append(v);
    }

    public StringBuilder appendCodePoint(int i) {
        return sb.appendCodePoint(i);
    }

    public StringBuilder delete(int i, int i1) {
        return sb.delete(i, i1);
    }

    public StringBuilder deleteCharAt(int i) {
        return sb.deleteCharAt(i);
    }

    public StringBuilder replace(int i, int i1, String s) {
        return sb.replace(i, i1, s);
    }

    public StringBuilder insert(int i, char[] chars, int i1, int i2) {
        return sb.insert(i, chars, i1, i2);
    }

    public StringBuilder insert(int i, Object o) {
        return sb.insert(i, o);
    }

    public StringBuilder insert(int i, String s) {
        return sb.insert(i, s);
    }

    public StringBuilder insert(int i, char[] chars) {
        return sb.insert(i, chars);
    }

    public StringBuilder insert(int i, CharSequence charSequence) {
        return sb.insert(i, charSequence);
    }

    public StringBuilder insert(int i, CharSequence charSequence, int i1, int i2) {
        return sb.insert(i, charSequence, i1, i2);
    }

    public StringBuilder insert(int i, boolean b) {
        return sb.insert(i, b);
    }

    public StringBuilder insert(int i, char c) {
        return sb.insert(i, c);
    }

    public StringBuilder insert(int i, int i1) {
        return sb.insert(i, i1);
    }

    public StringBuilder insert(int i, long l) {
        return sb.insert(i, l);
    }

    public StringBuilder insert(int i, float v) {
        return sb.insert(i, v);
    }

    public StringBuilder insert(int i, double v) {
        return sb.insert(i, v);
    }

    public int indexOf(String s) {
        return sb.indexOf(s);
    }

    public int indexOf(String s, int i) {
        return sb.indexOf(s, i);
    }

    public int lastIndexOf(String s) {
        return sb.lastIndexOf(s);
    }

    public int lastIndexOf(String s, int i) {
        return sb.lastIndexOf(s, i);
    }

    public StringBuilder reverse() {
        return sb.reverse();
    }

    public int length() {
        return sb.length();
    }

    public int capacity() {
        return sb.capacity();
    }

    public void ensureCapacity(int i) {
        sb.ensureCapacity(i);
    }

    public void trimToSize() {
        sb.trimToSize();
    }

    public void setLength(int i) {
        sb.setLength(i);
    }

    public char charAt(int i) {
        return sb.charAt(i);
    }

    public int codePointAt(int i) {
        return sb.codePointAt(i);
    }

    public int codePointBefore(int i) {
        return sb.codePointBefore(i);
    }

    public int codePointCount(int i, int i1) {
        return sb.codePointCount(i, i1);
    }

    public int offsetByCodePoints(int i, int i1) {
        return sb.offsetByCodePoints(i, i1);
    }

    public void getChars(int i, int i1, char[] chars, int i2) {
        sb.getChars(i, i1, chars, i2);
    }

    public void setCharAt(int i, char c) {
        sb.setCharAt(i, c);
    }

    public String substring(int i) {
        return sb.substring(i);
    }

    public CharSequence subSequence(int i, int i1) {
        return sb.subSequence(i, i1);
    }

    public String substring(int i, int i1) {
        return sb.substring(i, i1);
    }

    public IntStream chars() {
        return sb.chars();
    }

    public IntStream codePoints() {
        return sb.codePoints();
    }
}
