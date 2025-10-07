package org.javahowto.Numbers;

public class SumOfDigits {

    public static int sumOfDigits(int number) {
        int sum = 0;
        while(number > 0) {
            sum = sum + number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = sumOfDigits(52);
        System.out.println(result);
    }
}
