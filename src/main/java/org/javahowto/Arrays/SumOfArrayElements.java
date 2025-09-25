package org.javahowto.Arrays;

public class SumOfArrayElements {

    public static int sumOfArray(int[] arr){
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i]; // sum = sum + arr[i]
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int result = sumOfArray(numbers);
        System.out.println("Sum value in array: " + result);
    }
}
