package org.javahowto.Strings;

public class ConvertStringToArray {

    public static void convertStringToArray(String str) {
        char[] myArr = str.toCharArray();

        for(char c : myArr) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        convertStringToArray("Hello");
    }
}
