package NiukeTOP101;

public class BM64 {
    public int minCostClimbingStairs (int[] cost) {
        int n = cost.length;
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = Math.min(cost[0], cost[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
}
