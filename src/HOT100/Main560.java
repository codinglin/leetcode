package HOT100;

import java.util.HashMap;
import java.util.Map;

public class Main560 {
    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int length = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int left = 0; left < length; left++) {
            for (int right = left; right < length; right++) {
                // 区间和 [left...right]，注意下标便宜
                if(preSum[right + 1] - preSum[left] == k) {
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        // key: 前缀和，value: key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1.
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            // preSum - (preSum - k) == k 的区间的个数是我们所关心的
            if(preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 0};
        int k = 0;
        subarraySum(nums, k);
    }
}
