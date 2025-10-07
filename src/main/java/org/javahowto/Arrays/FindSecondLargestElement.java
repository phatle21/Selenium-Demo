package org.javahowto.Arrays;

// For {5, 8, 1, 3, 10, 8} → Second largest = 8
// For {10, 10, 10} → No second largest (all values equal)
// For {1} → Invalid input (not enough elements)

// How To Find the Second Largest Element in an Array w3schools

import java.util.Arrays;

// gop them: tim so lon nhat va so lon thu hai trong mang
public class FindSecondLargestElement {
    // dung cach sap xep mang
    public static Integer findSecondLargest(int[] arr) {
        // check mang
        if (arr == null || arr.length < 2) {
            System.out.println("Mảng phải có ít nhất 2 phần tử.");
            return null;
        }

        // sao chep mang
        int[] sorted = Arrays.copyOf(arr, arr.length);
        // sap xep mang
        Arrays.sort(sorted);

        for(int i = sorted.length - 2; i >= 0; i--) {
            // So sánh từng phần tử với phần tử lớn nhất (sorted[sorted.length - 1])
            if(sorted[i] < sorted[sorted.length -1]){
                return sorted[i];
            }
        }

        // Nếu không tìm thấy số nhỏ hơn lớn nhất → các phần tử giống nhau
        System.out.println("Không tìm thấy số lớn thứ hai (các phần tử có thể giống nhau).");
        return null;
    }

    public static void main(String[] args) {
     //   int[] numbers = {7, 3, 9, 9, 1, 5};
        int[] numbers = {34, 12, 78, 56, 91, 43};
        // int[] sorted = {12, 34, 43, 56, 78, 91};
        // sorted.length = 6
        // sorted[sorted.length - 1] = sorted[5] = 91 → Đây là số lớn nhất

        Integer result = findSecondLargest(numbers);
        if (result != null) {
            System.out.println("Số lớn thứ hai là: " + result);
        }
    }
}
