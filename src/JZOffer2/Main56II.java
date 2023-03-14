package JZOffer2;

public class Main56II {
    public int singleNumber(int[] nums) {
        // 使用与运算,可获取二进制数字 num 的最右一位 n_1: n1 = num & i;
        // 配合无符号右移操作,可获取 num 所有位的值 (即 n_1 ~ n_32): num = num >>> 1;
        // 建立一个长度为 32 的数组 counts,通过以上方法可记录所有数字的各二进制位的 1 的出现次数。
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                counts[j] += nums[i] & 1;
                nums[i] = nums[i] >>> 1;
            }
        }
        // 将 counts 各元素对 3 求余，则结果为 “只出现一次的数字” 的各二进制位。
        for (int i = 0; i < 32; i++) {
            counts[i] %= 3;
        }
        // 利用 左移操作 和 或运算 ，可将 counts 数组中各二进位的值恢复到数字 res 上（循环区间是 i∈[0,31]）。
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
