package org.javahowto.Strings;

import java.util.HashSet;
import java.util.Set;

public class CountVowelsInAString {

//    public static int countVowelsInAString(String str) {
//        int count = 0;
//        for(char c : str.toLowerCase().toCharArray()) {
//            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//                count++;
//            }
//        }
//        return count;
//    }

    public static void countVowelInAString(String text) {
        Set<Character> vowels = new HashSet<>();
        for (char v : new char[]{'a','e','i','o','u'}) {
            vowels.add(v);
        }
        int count = 0;
        for(char c: text.toLowerCase().toCharArray()){
            if(vowels.contains(c)){
                count++;
            }
        }
        System.out.println("Vowels: " + count);
    }

    public static void main(String[] args) {
//        int result = countVowelsInAString("Hello Java");
//        System.out.println(result);
        countVowelInAString("Hello Java");
    }
}
