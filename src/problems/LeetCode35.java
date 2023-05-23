package problems;

/**
 * 只看到 while(left < right) 里的 < ，不能说明右边界不能取到。真正看区间表示应该看左右边界到底如何设置。
 * 如果我们分析出下一轮搜索的范围是 [left..mid] 而设置 right = mid + 1，才表示搜索区间为 [左闭右开] 区间。这是因为 [left..right) = [left..mid+1) = [left..mid]
 * 我们已经可以确切地知道要搜索的数的右边界是什么，没有必要把右边界再 + 1
 *
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }
}
