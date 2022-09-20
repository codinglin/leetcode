package problems;

import java.util.*;

public class LeetCode217 {
    // 排序
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Hash表
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.getOrDefault(num, 0) == 1){
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}
