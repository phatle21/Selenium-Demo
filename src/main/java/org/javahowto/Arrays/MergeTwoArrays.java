package org.javahowto.Arrays;

public class MergeTwoArrays {
// viet cach khac

    public static void mergeTwoArray(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int idx = 0;
        for(int n : arr1) merged[idx++] = n;
        for (int n : arr2) merged[idx++] = n;

        for (int n : merged) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5};
        int[] arr2 = {1, 6};

        mergeTwoArray(arr1, arr2);
        // co the sort
    }
}
