package org.javahowto.Numbers;

public class EvenOrOddNumber {
    public static void checkEvenOrOddNumber(int number) {
        if(number % 2 == 0){
            System.out.println("so chan");
        } else {
            System.out.println("so le");
        }
    }
    public static void main(String[] args) {
       checkEvenOrOddNumber(5);

    }
}
