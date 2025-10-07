package org.javahowto.Strings;

public class RemoveWhitespace {
    public static void removeWhiteSpace(String string) {
        System.out.println(string.trim());
    }

    public static void main(String[] args) {
        removeWhiteSpace("  phat   ");
    }
}
