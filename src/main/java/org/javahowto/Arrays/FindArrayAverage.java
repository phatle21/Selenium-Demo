package org.javahowto.Arrays;

public class FindArrayAverage {

    public static float findArrayAverage(int[] arr) {
        float average, sum = 0;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        return average = sum / length;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 6};
        float result = findArrayAverage(numbers);
        System.out.println("Average of array = " + result);
    }
}
