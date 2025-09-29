package org.javahowto.Strings;

// số lần xuất hiện của các từ trong một chuỗi
// dùng split chia chuỗi thành một mảng các từ
// dùng hashmap<String, Integer> duyệt và lưu trữ

import java.util.HashMap;
import java.util.Map;

public class CountWords {
    public static void main(String[] args) {
       // String inputString = "AGEST Vietnam (AGV) is an affiliate company of AGEST Japan. Would you like to become a member of AGEST Vietnam";
        String inputString = "hello world hello";
        Map<String, Integer> wordCountMap = new HashMap<>();

        // tach chuoi thanh cac tu
        String[] words = inputString.split("\\s+"); // // Phân tách bằng một hoặc nhiều khoảng trắng

        // dem so lan xuat hien cua moi tu
        for (String word: words) {
            // nếu từ đã có trong map, tăng số lần lên 1
            if(wordCountMap.containsKey(word)){
                wordCountMap.put(word, wordCountMap.get(word) +1);
            } else {
                // néếu ko có, thì thêm từ vào map với số lần là 1
                wordCountMap.put(word, 1);
            }
        }

        System.out.println("So lan xuat hien cua cac tu ");
        //
//        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        wordCountMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
