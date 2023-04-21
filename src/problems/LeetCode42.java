package problems;

import java.util.Stack;

public class LeetCode42 {
    /**
     * 按列求
     * 根据较矮的那个墙和当前列的墙的高度可以分为三种情况。
     *      较矮的墙的高度大于当前列的墙的高度：有水
     *      较矮的墙的高度小于当前列的墙的高度：无水
     *      较矮的墙的高度等于当前列的墙的高度：无水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        // 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            // 找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if(height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if(height[j] > max_right) {
                    max_right = height[j];
                }
            }
            // 找出两端较小的
            int min = Math.min(max_left, max_right);
            // 只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if(min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     * 首先用两个数组：max_left[i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（注意：第 i 列左右边最高的墙，是不包括自身的）
     * 对于 max_left我们其实可以这样求。
     * max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
     * 对于 max_right我们可以这样求。
     * max_right[i] = Max(max_right[i+1],height[i+1]) 。它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if(min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0, max_left = 0, max_right = 0, left = 1, right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            // 从左到右更
            if(height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if(min > height[left]) {
                    sum += (min - height[left]);
                }
                left ++;
            }
            // 从右到左更
            else{
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if(min > height[right]) {
                    sum += (min - height[right]);
                }
            }
            right --;
        }
        return sum;
    }

    /**
     * 单调栈
     * 我们用栈保存每堵墙。
     * 当遍历墙的高度的时候，如果当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈。
     * 如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
     * 总体的原则就是，
     * 当前高度小于等于栈顶高度，入栈，指针后移。
     * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第 2 步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if(stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1; // 两堵墙之间的距离
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}

class LeetCode42_1 {
    public int trap(int[] height) {
        return 0;
    }
}
