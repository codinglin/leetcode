package problems;

import java.util.Arrays;

public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
//        Arrays.fill(dp[1],1);
//        for(int i=1;i<=n;i++){
//            dp[1][i]=1;
//        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1||j==1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
