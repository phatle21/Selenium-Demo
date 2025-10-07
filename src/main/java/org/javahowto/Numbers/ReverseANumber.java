package org.javahowto.Numbers;

public class ReverseANumber {

    public static int reverseNumber(int number) {
        int reversed = 0;

        while(number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10; // number = number / 10
        }
        return reversed;
    }
    /*
@ First Iteration:
digit = 123 % 10 = 3
reversed = 0 * 10 + 3 = 3
number = 123 / 10 = 12

@ Second Iteration:
digit = 12 % 10 = 2
reversed = 3 * 10 + 2 = 32
number = 12 / 10 = 1

@ Third Iteration:
digit = 1 % 10 = 1
reversed = 32 * 10 + 1 = 321
number = 1 / 10 = 0
    * */

    public static void main(String[] args) {
        int result = reverseNumber(1234);
        System.out.println(result);
    }
}
