package problems;

public class LeetCode376 {
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int preDiff = nums[1] - nums[0];
        int count = preDiff != 0 ? 2 : 0;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                count++;
                preDiff = diff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        wiggleMaxLength(new int[]{3, 3, 3, 2, 5});
    }
}
