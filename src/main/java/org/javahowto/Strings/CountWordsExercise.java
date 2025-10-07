package org.javahowto.Strings;

public class CountWordsExercise {
    public static void countWordExercies(String str) {
        int countWords = str.split("\\s").length;
        System.out.println(countWords);
    }
    public static void main(String[] args) {
        countWordExercies("One Two Three Four");
    }
}
