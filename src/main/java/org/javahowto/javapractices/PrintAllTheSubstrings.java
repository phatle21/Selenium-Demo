package org.javahowto.javapractices;



public class PrintAllTheSubstrings {

    // Tìm các chuỗi con trong 1 chuỗi cho trước
    public static void printSubStrings(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    // Tìm một chuỗi con có nằm trong chuỗi cho trước
    // phan biet contains và indexOf
    // contains: trả về true nếu chuỗi sub xuất hiện trong str.
    // indexOf: int (chỉ số hoặc -1 nếu không tìm thấy)
    public static boolean findSubString(String str, String sub) {
        return str.contains(sub);
    }

    public static void main(String[] args) {
     //   String str = "abc"; // n*(n+1)/2

        String giveString = "Tôi tên là Lê Thành Phát";
        String findString = "Phát";
       if (findSubString(giveString, findString)) {
           System.out.println("Tìm thấy chuỗi " + findString);
       } else {
           System.out.println("Không tìm thấy " + findString);
       };
    }
}
