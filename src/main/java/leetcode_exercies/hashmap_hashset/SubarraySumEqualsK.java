package leetcode_exercies.hashmap_hashset;

// Leetcode 560
/*
Mục tiêu: Đếm số lượng subarray có tổng = K.
Ý tưởng HashMap:
    Lưu prefixSum và số lần xuất hiện của nó.
    Nếu prefixSum - K đã có trong map → có 1 subarray thỏa mãn.
Pattern: map.put(sum, map.getOrDefault(sum, 0) + 1)
 */

public class SubarraySumEqualsK {


    public static void main(String[] args) {

    }
}
