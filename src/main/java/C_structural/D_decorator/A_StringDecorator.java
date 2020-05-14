package C_structural.D_decorator;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.stream.IntStream;

public class A_StringDecorator {
    public static void main(String[] args) {
        MagicString ms = new MagicString("hello");
        System.out.println("The word " + ms + " has " + ms.getCantOfVowels() + " vowels");
    }
}

class MagicString {
    private String string;

    public MagicString(String string) {
        this.string = string;
    }

    public long getCantOfVowels() {
        final String VOWELS = "aeiou";
        return string.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> VOWELS.contains(c.toString())).count();
    }

    @Override
    public String toString() {
        return string;
    }

    /**
     *
     * DELEGATE METHODS
     */

    public int length() {
        return string.length();
    }

    public boolean isEmpty() {
        return string.isEmpty();
    }

    public char charAt(int i) {
        return string.charAt(i);
    }

    public int codePointAt(int i) {
        return string.codePointAt(i);
    }

    public int codePointBefore(int i) {
        return string.codePointBefore(i);
    }

    public int codePointCount(int i, int i1) {
        return string.codePointCount(i, i1);
    }

    public int offsetByCodePoints(int i, int i1) {
        return string.offsetByCodePoints(i, i1);
    }

    public void getChars(int i, int i1, char[] chars, int i2) {
        string.getChars(i, i1, chars, i2);
    }

    @Deprecated
    public void getBytes(int i, int i1, byte[] bytes, int i2) {
        string.getBytes(i, i1, bytes, i2);
    }

    public byte[] getBytes(String s) throws UnsupportedEncodingException {
        return string.getBytes(s);
    }

    public byte[] getBytes(Charset charset) {
        return string.getBytes(charset);
    }

    public byte[] getBytes() {
        return string.getBytes();
    }

    public boolean contentEquals(StringBuffer stringBuffer) {
        return string.contentEquals(stringBuffer);
    }

    public boolean contentEquals(CharSequence charSequence) {
        return string.contentEquals(charSequence);
    }

    public boolean equalsIgnoreCase(String s) {
        return string.equalsIgnoreCase(s);
    }

    public int compareTo(String s) {
        return string.compareTo(s);
    }

    public int compareToIgnoreCase(String s) {
        return string.compareToIgnoreCase(s);
    }

    public boolean regionMatches(int i, String s, int i1, int i2) {
        return string.regionMatches(i, s, i1, i2);
    }

    public boolean regionMatches(boolean b, int i, String s, int i1, int i2) {
        return string.regionMatches(b, i, s, i1, i2);
    }

    public boolean startsWith(String s, int i) {
        return string.startsWith(s, i);
    }

    public boolean startsWith(String s) {
        return string.startsWith(s);
    }

    public boolean endsWith(String s) {
        return string.endsWith(s);
    }

    public int indexOf(int i) {
        return string.indexOf(i);
    }

    public int indexOf(int i, int i1) {
        return string.indexOf(i, i1);
    }

    public int lastIndexOf(int i) {
        return string.lastIndexOf(i);
    }

    public int lastIndexOf(int i, int i1) {
        return string.lastIndexOf(i, i1);
    }

    public int indexOf(String s) {
        return string.indexOf(s);
    }

    public int indexOf(String s, int i) {
        return string.indexOf(s, i);
    }

    public int lastIndexOf(String s) {
        return string.lastIndexOf(s);
    }

    public int lastIndexOf(String s, int i) {
        return string.lastIndexOf(s, i);
    }

    public String substring(int i) {
        return string.substring(i);
    }

    public String substring(int i, int i1) {
        return string.substring(i, i1);
    }

    public CharSequence subSequence(int i, int i1) {
        return string.subSequence(i, i1);
    }

    public String concat(String s) {
        return string.concat(s);
    }

    public String replace(char c, char c1) {
        return string.replace(c, c1);
    }

    public boolean matches(String s) {
        return string.matches(s);
    }

    public boolean contains(CharSequence charSequence) {
        return string.contains(charSequence);
    }

    public String replaceFirst(String s, String s1) {
        return string.replaceFirst(s, s1);
    }

    public String replaceAll(String s, String s1) {
        return string.replaceAll(s, s1);
    }

    public String replace(CharSequence charSequence, CharSequence charSequence1) {
        return string.replace(charSequence, charSequence1);
    }

    public String[] split(String s, int i) {
        return string.split(s, i);
    }

    public String[] split(String s) {
        return string.split(s);
    }

    public static String join(CharSequence charSequence, CharSequence... charSequences) {
        return String.join(charSequence, charSequences);
    }

    public static String join(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        return String.join(charSequence, iterable);
    }

    public String toLowerCase(Locale locale) {
        return string.toLowerCase(locale);
    }

    public String toLowerCase() {
        return string.toLowerCase();
    }

    public String toUpperCase(Locale locale) {
        return string.toUpperCase(locale);
    }

    public String toUpperCase() {
        return string.toUpperCase();
    }

    public String trim() {
        return string.trim();
    }

    public char[] toCharArray() {
        return string.toCharArray();
    }

    public static String format(String s, Object... objects) {
        return String.format(s, objects);
    }

    public static String format(Locale locale, String s, Object... objects) {
        return String.format(locale, s, objects);
    }

    public static String valueOf(Object o) {
        return String.valueOf(o);
    }

    public static String valueOf(char[] chars) {
        return String.valueOf(chars);
    }

    public static String valueOf(char[] chars, int i, int i1) {
        return String.valueOf(chars, i, i1);
    }

    public static String copyValueOf(char[] chars, int i, int i1) {
        return String.copyValueOf(chars, i, i1);
    }

    public static String copyValueOf(char[] chars) {
        return String.copyValueOf(chars);
    }

    public static String valueOf(boolean b) {
        return String.valueOf(b);
    }

    public static String valueOf(char c) {
        return String.valueOf(c);
    }

    public static String valueOf(int i) {
        return String.valueOf(i);
    }

    public static String valueOf(long l) {
        return String.valueOf(l);
    }

    public static String valueOf(float v) {
        return String.valueOf(v);
    }

    public static String valueOf(double v) {
        return String.valueOf(v);
    }

    public String intern() {
        return string.intern();
    }

    public IntStream chars() {
        return string.chars();
    }

    public IntStream codePoints() {
        return string.codePoints();
    }
}
