package JZOffer2;

import java.util.Arrays;

public class Main39 {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

/**
 * 摩尔投票法
 * 推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 -1 ，则一定有所有数字的 票数和 > 0
 * 推论二： 若数组的前 a 个数字的 票数和 = 0，则 数组剩余 (n-a) 个数字的 票数和一定仍 >0，即后 (n-a) 个数字的 众数仍为 x 。
 * 根据以上推论，记数组首个元素为 n_1，众数为 x，遍历并统计票数。当发生票数和 = 0 时，剩余数组的众数一定不变 ，这是由于：
 *      当 n_1 = x : 抵消的所有数字中，有一半是众数 x。
 *      当 n_1 != x : 抵消的所有数字中，众数 x 的数量最少为 0 个，最多为一半。
 */
class Main39_1{
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if(votes == 0) x = num;
            votes += num == x ? 1:-1;
        }
        return x;
    }
}
