package org.javahowto.Arrays;

public class FindDuplicates {

    public static void findDuplicate(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    System.out.println("Duplicate = " + arr[i]);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 5, 1};
        findDuplicate(nums);
    }
}
