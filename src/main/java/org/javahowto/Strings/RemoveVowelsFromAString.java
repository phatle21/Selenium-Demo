package org.javahowto.Strings;

public class RemoveVowelsFromAString {

    public static void removeVowelsFromAString(String string) {
        System.out.println(string.replaceAll("[aeiouAEIOU]", ""));
    }

    public static void main(String[] args) {
        removeVowelsFromAString("Hello Java");
    }
}
