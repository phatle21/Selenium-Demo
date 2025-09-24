package org.example;

public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};  // Example array
        int sum = 0;

        // Loop through the array and add each element to sum
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("The sum of the array is: " + sum);
    }
}

