package WeBankTest;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(getMaxSum(a));
    }

    private static int getMaxSum(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][5];
        dp[0][0] = a[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        int maxHe = dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0] + a[i], a[i]);
            maxHe = Math.max(maxHe, dp[i][0]);
            for (int j = 0; j < i; j++) {
                int sum1 = dp[j][0] + dp[i-1][0] - dp[j][1];
                int sum2 = dp[j][1] + dp[i-1][0] - dp[j][2];
                dp[i][1] = Math.max(dp[i][1], Math.max(sum1, sum2));
            }
            maxHe = Math.max(maxHe, dp[i][1]);
            for (int j = 0; j < i; j++) {
                int sum1 = dp[j][0] + dp[i-1][0] - dp[j][1];
                int sum2 = dp[j][1] + dp[i-1][0] - dp[j][2];
                dp[i][2] = Math.max(dp[i][2], Math.max(sum1, sum2));
            }
            maxHe = Math.max(maxHe, dp[i][2]);
        }
        return maxHe;
    }
}
