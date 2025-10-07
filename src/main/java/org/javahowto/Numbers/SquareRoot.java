package org.javahowto.Numbers;

public class SquareRoot {

    public static float squareRoot(int number) {
        return (float) Math.sqrt(number);
    }

    public static void main(String[] args) {
        float result = squareRoot(64);
        System.out.println(result);
    }
}
