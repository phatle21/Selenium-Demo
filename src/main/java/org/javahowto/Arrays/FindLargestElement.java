package org.javahowto.Arrays;

public class FindLargestElement {

    public static int findLargestElement(int arr[]) {
        int max = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(max > arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 25, 7, 99, 64};
        int largestNumber = findLargestElement(numbers);
        System.out.println("The largest number in array: " + largestNumber);
    }
}
