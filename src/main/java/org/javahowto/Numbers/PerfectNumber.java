package org.javahowto.Numbers;

public class PerfectNumber {
    // so hoan hao: tổng các ước số (không bao gồm chính nó) của nó bằng chính nó.
    public static int isPerfectNumber(int number) {
        int sum = 0;
        // 1 2 3
        // number / 2 vì ko co uoc so nao lon hon no
        for(int i = 1; i <= number / 2; i++) {
            if(number % i == 0){
                sum = sum + i;
            }
        }
        return sum;
    }

    // Hàm kiểm tra số hoàn hảo
    public static void kiemTraSoHoanHao(int n) {
        if (isPerfectNumber(n) == n) {
            System.out.println(n + " là số hoàn hảo.");
        }
    }

    public static void main(String[] args) {
        int limit = 6;  // Tìm các số hoàn hảo trong phạm vi 1 đến 10000
        System.out.println("Các số hoàn hảo trong phạm vi 1 đến " + limit + " là:");

        // Duyệt qua các số từ 1 đến limit
        for (int i = 1; i <= limit; i++) {
            kiemTraSoHoanHao(i);
        }
    }
}
