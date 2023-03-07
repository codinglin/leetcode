package problems;

public class LeetCode209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4,3};
        minSubArrayLen(7, nums);
    }
}
