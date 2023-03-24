package problems;

public class LeetCode494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrace(nums, target, 0, 0);
        return count;
    }

    private void backtrace(int[] nums, int target, int index, int sum) {
        if(index == nums.length) { // 题目要求将全部整数联合起来，因此条件必须是 i == nums.length
            if(sum == target) count++;
            return;
        }
        backtrace(nums, target, index + 1, sum + nums[index]);
        backtrace(nums, target, index + 1, sum - nums[index]);
    }
}
