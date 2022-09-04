package HOT100;

public class Main152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums,0, maxF, 0, n);
        System.arraycopy(nums,0, minF, 0, n);
        for(int i=1; i<n; i++){
            maxF[i] = Math.max(maxF[i-1]*nums[i], Math.max(minF[i-1]*nums[i], nums[i]));
            minF[i] = Math.min(maxF[i-1]*nums[i], Math.min(minF[i-1]*nums[i], nums[i]));
        }
        int ans = maxF[0];
        for(int i=1; i<n; i++){
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}
