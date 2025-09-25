package org.javahowto.Numbers;

public class RandomNumber {

    public static void generateRandomNumber() {
        int randomNum = (int)(Math.random() * 101); // 0 to 100
        System.out.println("Random Number = " + randomNum);
    }

    public static void main(String[] args) {
        generateRandomNumber();
    }
}
