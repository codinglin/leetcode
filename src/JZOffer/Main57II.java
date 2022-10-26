package JZOffer;

import java.util.*;

public class Main57II {
    public static int[][] findContinuousSequence(int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 1;
        List<Integer> queue = new ArrayList<>();
        queue.add(1);
        int right = 2;
        while(right <= target/2 + 1){
            queue.add(right);
            sum += right;
            while(sum > target){
                sum -= queue.remove(0);
            }
            if(sum == target){
                result.add(new ArrayList<>(queue));
                sum -= queue.remove(0);
            }
            right ++;
        }
        int[][] res = new int[result.size()][];
        for(int i = 0; i < result.size(); i++) {
            res[i] =  result.get(i).stream().mapToInt(Integer::valueOf).toArray();
        }
        return res;
    }

    public static void main(String[] args) {
        findContinuousSequence(15);
    }
}

class Main57II_1{
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
