package JZOffer;

/**
 * dp[i]代表以prices[i]为结尾的子数组的最大利润（以下简称为前i日的最大利润）
 *      前i日最大利润 = max(前(i-1)日最大利润，第i日价格 - 前i日最低价格）
 *      dp[i] = max(dp[i-1], prices[i] - min(prices[0:i]))
 */
public class Main63 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
