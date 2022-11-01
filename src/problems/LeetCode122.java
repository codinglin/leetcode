package problems;

public class LeetCode122 {
    /**
     * dp[i][j] 表示到下标为i的这一天，持股状态为j时，我们手上拥有的最大现金数。
     * 注意：限定持股状态为 j 是为了方便推导状态转移方程，这样的做法满足 无后效性。
     * 其中：
     *      第一维 i 表示下标为 i 的那一天（具有前缀性质，即考虑了之前天数的交易）
     *      第二维 j 表示下标为 i 的那一天是持有股票，还是持有现金。这里 0 表示持有现金，1 表示持有股票。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2){
            return 0;
        }
        int[][] dp = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    /**
     * 贪心算法：由于不限制交易次数，只要今天股价比昨天高，就交易
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

    /**
     * 方法一：暴力搜索（超时）
     */
    private int res;

    public int maxProfit1(int[] prices){
        int length = prices.length;
        if(length < 2){
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, length, 0, res);
        return this.res;
    }

    /**
     *
     * @param prices 股价数组
     * @param index 当前是第几天，从 0 开始
     * @param length 数组长度
     * @param status 0 表示不持有股票，1 表示持有股票
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int length, int status, int profit) {
        if(index == length){
            this.res = Math.max(this.res, profit);
            return;
        }
        dfs(prices, index + 1, length, status, profit);
        if(status == 0){
            dfs(prices, index + 1, length, 1, profit - prices[index]);
        }else{
            dfs(prices, index + 1, length, 0, profit + prices[index]);
        }
    }
}
