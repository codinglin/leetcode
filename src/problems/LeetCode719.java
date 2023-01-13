package problems;

import java.util.Arrays;

/**
 * 排序 + 二分查找 + 双指针
 */
public class LeetCode719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if(count_not_greater(mid, nums) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int count_not_greater(int diff, int[] nums) {
        int i = 0, ans = 0;
        for(int j = 0; j < nums.length; j ++){
            while(nums[j] - nums[i] > diff) {
                i ++;
            }
            ans += j - i;
        }
        return ans;
    }
}
