package org.javahowto.Strings;

import java.util.Arrays;

public class CheckAnagramStrings {
    // Two strings are anagrams if they contain the same characters in a different order:

    public static void checkAnagramStrings(String str1, String str2) {

        // Explanation: We convert both strings to arrays, sort them, and check if they are equal.
        // If yes, the strings are anagrams.
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean isAnagram = Arrays.equals(arr1, arr2);
        System.out.println(isAnagram ? "Anagram" : "Not Anagram");
    }

    public static void main(String[] args) {
        checkAnagramStrings("listen", "silent");
    }
}
