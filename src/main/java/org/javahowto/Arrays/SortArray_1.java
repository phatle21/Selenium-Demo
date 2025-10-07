package org.javahowto.Arrays;

import java.util.Arrays;

public class SortArray_1 {

    // using Arrays.sort()
    public static void sortArray(int[] arr) {
        Arrays.sort(arr);
    }
    // sort by algorithms (bubble sort)
    public static void useBubbleSort(int[] arr) {
        int n = arr.length;
        int temp;
        // cách 1
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n - 1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 6};
    //    sortArray(numbers);
    //    System.out.println("Array after sort: " + Arrays.toString(numbers)); // ???

          useBubbleSort(numbers);
          System.out.println("Array after sort: " + Arrays.toString(numbers));

    }
}
