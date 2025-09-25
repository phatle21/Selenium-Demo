package org.javahowto.Numbers;

import java.util.Scanner;

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
