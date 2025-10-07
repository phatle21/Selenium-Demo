package org.javahowto.Numbers;

import java.util.Scanner;

// swap không dùng biến tạm
// a = 5, b = 10 => a = 10 và b = 5

// a = a + b = 5 + 10 = 15
// b = a - b = 15 - 10 = 5
// a = a - b = 15 - 5 = 10

public class SwapTwoVariables {
    public static void swapTwoVariables(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swap: a = " + a + ", b = " + b);
    }
    public static void main(String[] args) {
        swapTwoVariables(15, 10);
    }
}
