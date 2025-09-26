package org.javahowto.Numbers;

// dua vao 1 mang

public class Prime {

    public static boolean isPrime(int n){
        for(int i = 1; i <= Math.sqrt(2); i++){
            if(i % 2 == 0){

            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
}
