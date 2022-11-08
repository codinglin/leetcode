package problems;

import java.util.Scanner;

public class LeetCode121 {
    // 常规方法
    public static int maxProfit(int[] prices) {
        int minNum = 9999;
        int ans = 0;
        for(int i=0; i<prices.length; i++){
            minNum = Math.min(minNum,prices[i]);
            ans = Math.max(ans, prices[i]-minNum);
        }
        return ans;
    }

    // 动态规划解法
    public static int maxProfitDP(int[] prices) {
        int length=prices.length;
        if(length<2){
            return 0;
        }
        int [][] dp =new int [length][2];
        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为0，持股就需要减去第1天（下标为0）的股价
        dp[0][0]=0;
        dp[0][1]=-prices[0];

        // 从第二天开始遍历
        /*
        * dp[i][0]有两种情况：
        * dp[i-1][1] 前一天持股，今天卖出。
        * dp[i-1][0] 前一天不持股，保持不变。
        *
        * dp[i][1]也有两种情况：
        * dp[i-1][1] 前一天持股，今天扔持股。
        * dp[i-1][0] 前一天不持股，今天买入。
        */
        for(int i=1; i<length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[length-1][0];
    }


    public int maxProfit1(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            max = Math.max((prices[i] - dp[i]), max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<prices.length;i++){
            prices[i]=scanner.nextInt();
        }
        int ans = maxProfitDP(prices);
        System.out.println(ans);
    }
}


class LeetCode121_1{
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int minCost = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i] < minCost){
                minCost = prices[i];
            }
            dp[i] = Math.max(dp[i-1], prices[i] - minCost);
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1,2});
    }
}
