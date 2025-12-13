package leetcode_exercies.hashmap_hashset;

// LeetCode 1

/*
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Giải thích: nums[0] + nums[1] = 2 + 7 = 9

brute force: 2 vong lap for - O(n^2)
hash map: lưu phần bù - O(n)
 */

// Arrays.toString()

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // cach 1: brute force
//    public int[] twoSum(int[] nums, int target) {
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{};
//    }

    // cach 2: hashmap
    // x + y = target => y = target - x
    /*
    Khi duyệt từng phần tử trong mảng:
    Mỗi lần gặp một số x, ta tính xem nó cần “số gì” để tạo ra target
    → complement = target - x
    Nếu “số cần thiết” này đã xuất hiện trước đó trong mảng
    → Ta đã tìm được cặp x và complement.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // key: giá trị trong mảng
        // value: vị trí (index) của giá trị đó
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Kiểm tra xem “số còn thiếu” đã có trong map chưa
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // Nếu chưa có, lưu giá trị hiện tại vào map
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        // Indices: [0, 1] là vị trí index của 2 số
        if (result.length == 2) {
            System.out.println("Indices: " + Arrays.toString(result));
            System.out.println("Values: " + nums[result[0]] + " + " + nums[result[1]] + " = " + target);
        } else {
            System.out.println("Không tìm thấy cặp số phù hợp.");
        }
    }
}
