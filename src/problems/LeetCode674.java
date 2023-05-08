package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长连续子序列
 */
public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}

class LeetCode674_1{
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}

class LeetCode674_2 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int ans = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                count ++;
            } else {
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
