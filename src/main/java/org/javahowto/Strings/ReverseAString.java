package org.javahowto.Strings;

public class ReverseAString {
    public static void reverseString(String originalString) {
        String reversedString = "";
        for(int i = 0; i < originalString.length(); i++){
            reversedString = originalString.charAt(i) + reversedString;
        }
        System.out.println(reversedString);
    }
    public static void main(String[] args) {
        reverseString("phatle");
    }
}
