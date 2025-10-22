package leetcode_exercies.hashmap_hashset;

// Leetcode 242

/*
Mục tiêu: Kiểm tra 2 chuỗi có là hoán vị của nhau không (có cùng chữ cái và tần suất).
Ý tưởng HashMap:
    Đếm tần suất từng ký tự trong chuỗi 1.
    Giảm tần suất khi duyệt chuỗi 2.
    Nếu có ký tự nào lệch → false.
Pattern: map.put(char, map.getOrDefault(char, 0) + 1)
 */

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Bước 1: Đếm tần suất từng ký tự trong s
        for(char c: s.toCharArray()) {
            // toCharArray: chuỗi thành một mảng ký tự
            map.put(c, map.getOrDefault(c, 0) + 1);
            // getOrDefault(): truy xuất giá trị tương ứng với một khóa,
            // và nếu khóa không tồn tại, sẽ trả về giá trị mặc định mà bạn chỉ định
        }

        // Bước 2: Giảm tần suất khi duyệt t
        for(char c: t.toCharArray()) {
            if(!map.containsKey(c)) {
                return false; // t có ký tự không nằm trong s
            }

            map.put(c, map.get(c) - 1);

            if (map.get(c) < 0) {
                return false; // t dùng quá nhiều ký tự c
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car"));         // false
    }

}
