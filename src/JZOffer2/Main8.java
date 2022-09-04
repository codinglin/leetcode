package JZOffer2;

public class Main8 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
        while (end < n){
            sum += nums[end];
            while (sum >= target){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
