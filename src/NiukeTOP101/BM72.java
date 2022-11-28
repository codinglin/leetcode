package NiukeTOP101;

public class BM72 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
