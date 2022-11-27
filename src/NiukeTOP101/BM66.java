package NiukeTOP101;

public class BM66 {
    public String LCS (String str1, String str2) {
        // dp[i][j]表示到 str1 第 i 个到str2 第 j 个为止的公共子串长度
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        int pos = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                    pos = i - 1;
                }
            }
        }
        return str1.substring(pos - max + 1, pos + 1);
    }
}
