package org.javapractices;

// reverse 1 từ (trong 1 array)
// reverStringInArray

public class ReverseString {
    public static void printReverseString(String str) {
        for(int i = str.length() - 1; i >= 0; i--){
            System.out.print(str.charAt(i));
        }
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        printReverseString(text);
    }
}
