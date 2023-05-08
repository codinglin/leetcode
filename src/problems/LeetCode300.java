package problems;

import java.util.Arrays;

/**
 * dp[i]为考虑前i个元素，以第i个数字结尾的最长上升子序列的长度。
 * 在计算dp[i]之前，我们已经计算出dp[0...i-1]的值，则状态转移方程为：
 *      dp[i] = max(dp[j])+1, 其中 0<=j<i 且 num[j] < num[i]
 *      最后数组的最大上升子序列即所有dp[i]中的最大值
 *      LIS_length = max(dp[i]),其中0<=i<n
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(dp[i], maxAns);
        }
        return maxAns;
    }
}

/**
 * 最长上升子序列
 */
class LeetCode300_1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}

class LeetCode300_2 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int mid = (i + j) / 2;
                if(tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if(res == j){
                res ++;
            }
        }
        return res;
    }
}
