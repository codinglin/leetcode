package problems;

import java.util.Arrays;

/**
 * 思路分析：
 *
 * 根据题意可以知道：珂珂吃香蕉的速度越小，耗时越多。反之，速度越大，耗时越少，这是题目的 单调性；
 * 我们要找的是速度。因为题目限制了珂珂一个小时之内只能选择一堆香蕉吃，因此速度最大值就是这几堆香蕉中，数量最多的那一堆。速度的最小值是 1，其实还可以再分析一下下界是多少，由于二分搜索的时间复杂度很低，严格的分析不是很有必要；
 * 还是因为珂珂一个小时之内只能选择一堆香蕉吃，因此：每堆香蕉吃完的耗时 = 这堆香蕉的数量 / 珂珂一小时吃香蕉的数量。根据题意，这里的 / 在不能整除的时候，需要向上取整。
 * 注意：当「二分查找」算法猜测的速度恰好使得珂珂在规定的时间内吃完香蕉的时候，还应该去尝试更小的速度是不是还可以保证在规定的时间内吃完香蕉。
 *
 * 这是因为题目问的是「最小速度 」。
 */
public class LeetCode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, right = 0;
        Arrays.sort(piles);
        for (int i = 0; i < n; i++) {
            right = Math.max(right, piles[i]);
        }
        int left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(possible(mid, piles) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int possible(int cost, int[] piles) {
        int count = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            count += (pile + cost - 1) / cost;
        }
        return count;
    }
}
