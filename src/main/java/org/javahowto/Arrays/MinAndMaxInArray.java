package org.javahowto.Arrays;

public class MinAndMaxInArray {

    public static void findMinAndMaxInArray(int[] arr){
        int max = arr[0];
        int min = arr[0];

        for(int n : arr) {
            if(n > max) {
                max = n;
            }
            if(n < min) {
                min = n;
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        int[] numbers = {45, 12, 98, 33, 27};
        findMinAndMaxInArray(numbers);
    }
}
