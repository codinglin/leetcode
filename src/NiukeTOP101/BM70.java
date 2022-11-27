package NiukeTOP101;

import java.util.Arrays;

public class BM70 {
    public int minMoney (int[] arr, int aim) {
        // 小于 1 都返回 0
        if(aim < 1){
            return 0;
        }
        int[] dp = new int[aim + 1];
        // 一开始设置为最大值 aim + 1，因此货币最小 1 元，即货币数不会超过aim.
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        // 遍历 1 - aim 元
        for (int i = 1; i <= aim; i++) {
            // 每种面值的货币都要枚举
            for (int j = 0; j < arr.length; j++) {
                // 如果面值不超过要凑的钱才能用
                if(arr[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        return dp[aim] > aim ? -1 : dp[aim];
    }
}
