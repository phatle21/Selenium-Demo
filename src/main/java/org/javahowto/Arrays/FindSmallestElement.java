package org.javahowto.Arrays;

public class FindSmallestElement {

    public static void findSmallestElement(int[] array) {
        int smallestElement = array[0];
        for(int i = 1 ; i < array.length; i++) {
            if(smallestElement > array[i]) {
                smallestElement = array[i];
            }
        }
        System.out.println(smallestElement);

    }

    public static void main(String[] args) {
        int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
        findSmallestElement(ages);
    }
}
