package JZOffer;

import java.util.Arrays;

/**
 * 动态规划
 * 设输入n个骰子的解（即概率列表）为f(n),其中[点数和]为x的概率f(n,x)
 * 当添加骰子的点数为 1 时，前 n - 1 个骰子的点数和应为 x - 1 ，方可组成点数和 x ；同理，当此骰子为 2 时，前 n - 1 个骰子应为 x - 2 ；以此类推，直至此骰子点数为 6 。将这 6 种情况的概率相加，即可得到概率 f(n, x)。递推公式如下所示：
 *
 * 给定n个骰子，n个骰子[点数和]为[n,6n],数量为6n-n+1=5n+1种
 */
public class Main60 {
    // 暴力递归
    public double[] dicesProbabilityViolence(int n) {
        // 抛n个骰子，点数和共有6^n种情况，共有5*n+1种不重复点数和
        double[] res = new double[5*n + 1];
        // 当前点数和
        int curSum = n;
        for (int i = 0; i < res.length; i++) {
            res[i] = process(curSum, n) / Math.pow(6, n);
        }
        return res;
    }

    // 使用n个骰子的情况下，搞出curSum的最大方法数
    private int process(int curSum, int n){
        if(n < 0 || curSum < 0){
            return 0;
        }
        if(n == 0 && curSum == 0){
            return 1;
        }
        int sum = 0;
        for (int i = 0; i <= 6; i++) {
            sum += process(curSum - i, n-1);
        }
        return sum;
    }

    public double[] dicesProbabilityViolence1(int n) {
        double[] res = new double[6];
        Arrays.fill(res,1/6.0);
        for(int i = 1; i < n; ++i){
            double[] temp = new double[res.length+5];
            for(int j = 0; j < res.length; ++j){
                for(int k = 0; k < 6; ++k) temp[j+k] += res[j]/6.0;
            }
            res = temp;
        }
        return res;
    }

    // 记忆化搜索
    public double[] dicesProbability2(int n) {
        // 抛n个骰子，点数和共有6^n种情况，共有5*n+1种不重复点数和
        double[] res = new double[5 * n + 1];
        int[][] memo = new int[6 * n + 1][n + 1];
        for (int i = 0; i <= 6 * n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }

        // 当前点数和
        int curSum = n;
        for (int i = 0; i < res.length; i++) {
            res[i] = f(curSum, n, memo) / Math.pow(6, n);
            curSum++; // 点数和+1
        }
        return res;
    }

    // 使用n个骰子的情况下，搞出curSum的最大方法数
    private int f(int curSum, int n, int[][] memo) {
        if (n < 0 || curSum < 0) {
            return 0;
        }
        if (n == 0 && curSum == 0) {
            return 1;
        }
        if (memo[curSum][n] != -1) {
            return memo[curSum][n];
        }
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += f(curSum - i, n - 1, memo);
        }
        memo[curSum][n] = sum;
        return sum;
    }

    public double[] dicesProbability(int n) {
        // 投n个骰子，点数和共有6^n种情况，共有5*n + 1种不重复点数和
        double[] res = new double[5*n + 1];
        //dp[i][j]代表当前使用i个骰子，点数和为j，能有多少种方法
        int[][] dp = new int[n+1][6*n+1];
        dp[0][0] = 1;
        for(int i =1; i<=n; i++){
            for(int j =i;j<=i*6; j++){
                for(int num = 1;num<=6 && j-num>=0;num++){
                    dp[i][j] +=dp[i-1][j-num];
                }
            }
        }
        // 填完dp表，开始填res表
        double all = Math.pow(6, n);
        int curSum = n;
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][curSum++] / all;
        }
        return res;
    }
}
