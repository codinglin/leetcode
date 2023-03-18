package JZOffer2;

/**
 * 当 i >= 2时，假设对正整数 i 拆分成第一个整数 j (1 <= j < i)，有两种方案：
 *      将 i 拆分成 j 和 i - j 的和，且 i - j 不再拆分成多个正整数，此时的乘积是 j * (i - j)
 *      将 i 拆分成 j 和 i - j 的和，且 i - j 继续拆分成多个正整数，此时的乘积是 j * dp[i - j]
 */
public class Main14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
