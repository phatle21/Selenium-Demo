package org.javahowto.Strings;

public class CountDigitsInAString {

    // Go through each character and count how many are digits (0-9).
    public static void countDigitsInAString(String string) {
        int count = 0;
        for(char c : string.toCharArray()) {
            if(Character.isDigit(c)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        countDigitsInAString("W3Schools was founded in 1998");
    }
}
