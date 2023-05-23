package problems;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if(prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }
}

class LeetCode1365_1 {
    /**
     * 注意到数组元素的值域为 [0, 100]
     * cnt[i] 表示数字 i 出现的次数。对于数字 i 而言，小于它的数目就为 cnt[0 ... i - 1] 的总和
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]] ++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }
}
