package problems;

/**
 * 我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于一下五种状态中的一种：
 *  1.未进行任何操作
 *  2.只进行过一次买操作
 *  3.进行了一次买操作和一次卖操作，即完成了一笔交易
 *  4.在完成了一笔交易的前提下，进行第二次买操作
 *  5.完成了全部两笔交易
 *  由于第一个状态的利润显然为 0，因此我们可以不用将其记录。对于剩下的四个状态，我们分别将它们的最大利润记为 buy1,sell1,by2,sell2
 *
 */
public class LeetCode123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
