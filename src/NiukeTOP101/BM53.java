package NiukeTOP101;

public class BM53 {
    public int minNumberDisappeared (int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i]) <= n){
                nums[Math.abs(nums[i]) - 1] = - 1 * nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
