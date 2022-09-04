package problems;

import java.util.Scanner;

public class LeetCode70 {
    public static int climbStairs(int n) {
        int dp[]=new int[n+1];
        if(n<2){
            return 1;
        }
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int climbStairsDP(int n) {
        int p=0,q=0,r=1;
        for(int i=1;i<=n;++i){
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }

    // 矩阵快速幂
    /**
     * [1 1  [ f(n)   = [f(n)+f(n-1)  = [f(n+1)
     *  1 0]  f(n-1)]        f(n)   ]     f(n) ]
     *
     * 因此 [f(n+1)  =  [1 1 ^n  [f(1)
     *      f(n)  ]     1 0]     f(0)]
     * 令 M = [1 1
     *        1 0]
     * */
    public static int climbStairsQuickPow(int n){
        int [][] q={{1, 1}, {1, 0}};
        int [][] res=pow(q,n);
        return res[0][0];
    }

    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int x=climbStairs(n);
        System.out.println(x);
    }
}
