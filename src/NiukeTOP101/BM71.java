package NiukeTOP101;

import java.util.Arrays;

public class BM71 {
    public int LIS (int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }
}
