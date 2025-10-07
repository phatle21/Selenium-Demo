package org.javahowto.Numbers;

public class PositiveOrNegative {
    public static void checkPositiveOrNegativeNumber(int number) {
        if(number > 0) {
            System.out.println("Positive");
        }else if (number < 0){
            System.out.println("Negative");
        } else {
            System.out.println("The digit is 0");
        }
    }

    public static void main(String[] args) {
        checkPositiveOrNegativeNumber(-1);
    }
}
