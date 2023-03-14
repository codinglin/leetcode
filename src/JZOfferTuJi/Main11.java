package JZOfferTuJi;

import java.util.HashMap;

// 前缀和 + 哈希表
public class Main11 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 初始化一个空的哈希表
        int pre_sum = 0; // 初始化pre_sum=0的前缀和变量
        int max_length = 0;
        /*
            规定空的前缀的结束下标为-1，由于空的前缀的元素和为0，因此在遍历之前，首先在哈希表中存入键值对(0, -1).
         */
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            pre_sum += nums[i] == 0 ? -1:1;
            if(map.containsKey(pre_sum)){
                max_length = Math.max(max_length, i - map.get(pre_sum));
            }else {
                map.put(pre_sum, i);
            }
        }
        return max_length;
    }
}
