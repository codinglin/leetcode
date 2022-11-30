package NiukeTOP101;

import java.util.Arrays;

/**
 * 最多可以买入卖出2次，那实际上相当于它的状态多了几个，对于每天有到此为止的最大收益和持股情况两种状态，持股情况有了5种变化，我们用：
 *  dp[i][0]表示到第i天为止没有买过股票的最大收益
 *  dp[i][1]表示到第i天为止买过一次股票还没有卖出的最大收益
 *  dp[i][2]表示到第i天为止买过一次也卖出过一次股票的最大收益
 *  dp[i][3]表示到第i天为止买过两次只卖出过一次股票的最大收益
 *  dp[i][4]表示到第i天为止买过两次同时也卖出过两次股票的最大收益
 */
public class BM82 {
    public int maxProfit (int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        // 初始化dp为最小
        Arrays.fill(dp[0], -10000);
        // 第0天不持有状态
        dp[0][0] = 0;
        // 第0天持有股票
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }
        return Math.max(dp[n-1][2], Math.max(0, dp[n-1][4]));
    }
}
