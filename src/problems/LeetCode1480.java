package problems;

public class LeetCode1480 {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int sum = 0;
        for (int i = 0; i <n; i++) {
            sum+=nums[i];
            result[i] = sum;
        }
        return result;
    }
}
