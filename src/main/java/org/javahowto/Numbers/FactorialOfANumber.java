package org.javahowto.Numbers;

public class FactorialOfANumber {
    public static void main(String[] args) {
        // tinh giai thua
        int n = 5;
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        System.out.println("Factorial of " + n + " is " + fact);
// Output: Factorial of 5 is 120
    }
}
