package org.javahowto.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleAnArray {
    public static void main(String[] args) {
        // Randomly change the order of elements in an array using Collections.shuffle():
        String[] fruits = {"Apple", "Banana", "Cherry", "Mango"};
        List<String> list = Arrays.asList(fruits);

        Collections.shuffle(list);

        System.out.println(list);
    }
}
