package HOT100;

/**
 * 回溯
 */
public class Main494 {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int index, int sum){
        if(index == nums.length) {
            if(sum == target) {
                count++;
            }
        } else {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }
}

/**
 * 动态规划
 */
class Main494_1 {
    /**
     * dp[i][j] 定义为从数组 nums 中 0 ~ i 的元素加减可以得到 j 的方法数量。
     * dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i]]
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了 sum 的绝对值范围则无法得到
        if(Math.abs(target) > Math.abs(sum)) {
            return 0;
        }
        int len = nums.length;
        int range = sum * 2 + 1; // 因为要包含负数所以要两倍，又要加上 0 这个中间的情况
        int[][] dp = new int[len][range]; // 这个数组是从总和为 -sum 开始的
        // 加上 sum 纯粹是因为下标界限问题，赋予第二维的值的时候都要加上 sum
        // 初始化
        // 第一个数只能分别组成 + - num[i] 的一种情况
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < len; i++) {
            for (int j = -sum; j <= sum; j++) {
                if((j + nums[i]) > sum) { // + 不成立，加上当前数大于 sum，只能减去当前的数
                    dp[i][j + sum] = dp[i - 1][j + sum - nums[i]] + 0;
                } else if ((j - nums[i]) < - sum) { // - 不成立，减去当前数小于 -sum，只能加上当前的数
                    dp[i][j + sum] = dp[i - 1][j + sum + nums[i]] + 0;
                } else { // + - 都可以
                    dp[i][j + sum] = dp[i - 1][j + sum + nums[i]] + dp[i - 1][j + sum - nums[i]];
                }
            }
        }
        return dp[len - 1][sum + target];
    }
}
