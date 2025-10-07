package org.javahowto.Strings;

public class PalindromeCheck {

    // palindrome: level
    public static boolean isStringPalindrome(String text) {

        for(int i = 0; i < text.length() / 2; i++) {
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Nếu bất kỳ ký tự nào từ đầu chuỗi khác với ký tự đối xứng từ cuối chuỗi,
    // hàm sẽ ngay lập tức trả về false

    /*
    * text.charAt(text.length() - 1 - i): Truy cập ký tự ở vị trí đối xứng từ cuối chuỗi.
    * Cách tính này sử dụng text.length() - 1 để lấy chỉ số của ký tự cuối cùng,
    * và sau đó trừ đi i để lấy ký tự đối xứng với ký tự ở vị trí i.
    * */

    public static void main(String[] args) {
        boolean checkPalindrome = isStringPalindrome("level");
        if (checkPalindrome) {
            System.out.println(" is a palindrome");
        } else {
            System.out.println(" is not a palindrome");
        }
    }
}
