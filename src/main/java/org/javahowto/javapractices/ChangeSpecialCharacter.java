package org.javahowto.javapractices;

// Thay đổi ký tự đặc biệt trong 1 chuỗi cho trước:
// thay ký tự @  bằng ký tự _

public class ChangeSpecialCharacter {

    public static String replaceDifferentSpecialCharacter(String str) {
        return str.replace('@', '-');
    }

    public static void main(String[] args) {
        String input = "Hello@gmail.com";
        System.out.println(replaceDifferentSpecialCharacter(input));
    }
}
