package leetcode_exercies.hashmap_hashset;

// Leetcode 217

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicate checker = new ContainsDuplicate();

        int[] nums = {1, 2, 3, 1}; //
        boolean result = checker.containsDuplicate(nums);

        System.out.println("Contains duplicate: " + result);
    }
}
