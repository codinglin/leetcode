package problems;

import tree.BalancedTree;

/**
 * 归并排序
 * 设前缀和数组为 preSum，则问题等价于求所有的下标对 (i,j)，满足 preSum[j]−preSum[i]∈[lower,upper]
 * 我们先考虑如下的问题：
 *      给定两个升序排列的数组 n1, n2, 试找出所有的下标对 (i,j)，满足 n2[j]-n1[i]∈[lower,upper]
 *      在已知两个数组均为升序的情况下，这一问题是相对简单的：我们在 n_2 中维护两个指针 l,r。起初，它们都指向 n_2的起始位置。
 *      最后计算出符合条件的下标对的数量
 */
public class LeetCode327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            long[] sorted = new long[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = sum[p1++];
                    } else {
                        sorted[p++] = sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }
}

/**
 * 平衡二叉搜索树
 * 运用到了前缀和二分的思想
 * 我们可以从左到右扫描前缀和数组。对于 preSum[j] 而言，
 * 首先进行两次查询，得到区间 [preSum[j]−upper,preSum[j]−lower] 内的整数数量；随后再将 preSum[j] 插入到平衡树中。
 */
class LeetCode327_1 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        BalancedTree tree = new BalancedTree();
        int ret = 0;
        for (long x : preSum) {
            long numLeft = tree.lowerBound(x - upper);
            int rankLeft = (numLeft == Long.MAX_VALUE ? (int)(tree.getSize() + 1) : tree.rank(numLeft)[0]);
            long numRight = tree.upperBound(x - lower);
            int rankRight = (numRight == Long.MAX_VALUE ? (int)(tree.getSize()) : tree.rank(numRight)[0] - 1);
            ret += (rankRight - rankLeft + 1);
            tree.insert(x);
        }
        return ret;
    }
}
