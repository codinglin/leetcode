package NiukeTOP101;

import java.util.Stack;

public class BM65 {
    public String LCS (String s1, String s2) {
        // 只要有一个空字符串便不会有子序列
        if(s1.length() == 0 || s2.length() == 0){
            return "-1";
        }
        int len1 = s1.length();
        int len2 = s2.length();
        // dp[i][j]表示第一个字符串到i位，第二个字符串到j位为止的最长公共子序列的长度
        int[][] dp = new int[len1+1][len2+1];
        // 遍历字符串每个位置求最大长度
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 遇到两个字符相等
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // 来自于左上方
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{ // 遇到两个字符不同
                    // 来自左边或者上方的最大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        //找出一个最长的公共子序列
        StringBuilder sb = new StringBuilder();
        int s1L = len1, s2L = len2;
        while(s1L != 0 && s2L != 0){
            if (s1.charAt(s1L-1) == s2.charAt(s2L-1)){
                sb.append(s1.charAt(s1L - 1));
                s1L--;
                s2L--;
            }else{
                if (dp[s1L-1][s2L] > dp[s1L][s2L-1]){
                    s1L--;
                }else{
                    s2L--;
                }
            }
        }
        if(sb.length() == 0)
            return "-1";
        return sb.reverse().toString();
    }
}
