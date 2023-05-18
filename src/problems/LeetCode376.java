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

class LeetCode376_1{
    /**
     * up[i] 表示以前 i 个元素中的某一个为结尾的最长的「上升摆动序列」的长度。
     * down[i] 表示以前 i 个元素中的某一个为结尾的最长的「下降摆动序列」的长度。
     * 最终的状态转移方程：
     *      up[i] = up[i-1] if(nums[i] <= nums[i-1])
     *              max(up[i-1], down[i-1]+1) if(nums[i] > nums[i-1])
     *      down[i] = down[i-1] if(nums[i] >= nums[i-1])
     *                max(up[i-1]+1, down[i-1]) if(nums[i] < nums[i-1])
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if(nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
