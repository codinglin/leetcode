package JZOffer2;

public class Main46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String sub = str.substring(i - 2, i);
            if(sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}
