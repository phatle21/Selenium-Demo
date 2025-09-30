package org.javahowto.Algorithms;

public class CheckPrimeNumber {

    public static boolean isPrime(int n) {
        if (n < 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(4) ? "la so nguyen to" : "khong la so nguyen to");
    }
}
