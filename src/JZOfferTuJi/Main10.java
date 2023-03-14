package JZOfferTuJi;


import java.util.HashMap;

/*
* 滑动窗口的条件：
*   while窗口内元素超过或者不满足条件时移动，但如果数组存在负数，遇到不满足题意的时候，应该移动窗口左边界，
*   还是扩大窗口右边界从而寻找到符合条件的情况呢？
* 当一种场景存在多种可能时，显然就是当前的算法不适配解题。
* 引入另一种数组中常用的算法——前缀和
* */
public class Main10 {
    public int subarraySum(int[] nums, int k) {
        int pre_sum = 0; // 初始化pre_sum=0的前缀和变量
        int ret = 0; // 记录满足题意的子数组数量
        HashMap<Integer, Integer> map = new HashMap<>(); // 初始化一个空的哈希表
        map.put(0, 1);
        for(int i: nums){
            pre_sum += i;
            /*
            *   将当前累加和减去整数k的结果，在哈希表中查找是否存在，
            *   如果存在该key值，证明以数组某一点为起点到当前位置满足题意，ret+=该key值对应的value.
            */
            ret += map.getOrDefault(pre_sum - k, 0);
            /*
            *   判断当前的累加和是否在哈希表中，若存在value + 1,若不存在value=1.
            */
            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }
        return ret;
    }
}
