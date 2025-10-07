package org.javahowto.Strings;

import java.util.HashMap;

// ??

public class CountCharacterFrequency {
    public static void countCharacterFrequency(String str){
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: str.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        System.out.println(freq);

    }

    public static void main(String[] args) {
        countCharacterFrequency("le thanh phat");
    }
}
