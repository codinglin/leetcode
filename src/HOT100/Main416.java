package HOT100;

public class Main416 {
    /**
     * 状态定义: dp[i][j] 表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j.
     *      不选择 nums[i]，如果在 [0, i-1] 这个子区间内已经有一部分元素，使得它们的和为 j，那么dp[i][j] = true;
     *      选择 nums[i]，如果在 [0, i-1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i].
     * 状态转移方程:
     *      dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
     * 一般写出状态转移方程以后，就需要考虑初始化条件。
     *      j - nums[i] 作为数组的下标，一定得保证大于等于 0，因此 nums[i] <= j;
     *      注意到一种非常特殊的情况：j 恰好等于 nums[i]，即单独 nums[i] 这个数恰好等于此时背包的容积 j，这也是符合题意的。
     * 这道题则要求选取的数字的和恰好等于整个数组的元素和的一半
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if((sum & 1) == 1){
            return false;
        }
        int target = sum / 2;
        // 创建二维状态数组：
        // 行：数组索引。列：容量(包括 0)
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来再修正
                dp[i][j] = dp[i - 1][j];
                if(nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}
