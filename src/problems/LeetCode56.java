package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1){
            return intervals;
        }
        int i, j;
        int temp[];
        List<int []> arr = new ArrayList<>();
        // 按照数组的左端点进行排序
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - 1 - i; j++) {
                if (intervals[j][0] > intervals[j+1][0]) {  // 相邻元素两两对比
                    temp = intervals[j+1];  // 元素交换
                    intervals[j+1] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        // 逐一进行合并
        j = 0;
        int k=0;
        for(i = 1; i < n; i++){
            temp = new int[2];
            temp[0] = intervals[k][0];
//            temp[0] = intervals[i-1][0];
            if(intervals[i][0] > intervals[j][1]){
                temp[1] = Math.max(intervals[j][1], intervals[i][0]);
                j = i;
                k = i;
                arr.add(temp);
                if(i==n-1){
                    arr.add(intervals[n-1]);
                }
            }else{
                j++;
                if(i==n-1){
                    temp[1] = intervals[i][1];
                    arr.add(temp);
                }
            }
        }

//        while(j<n){
//            temp[0] = intervals[j-1][0];
//            if(intervals[j][0] <= intervals[j-1][1]){
//                j++;
//            }
//        }
        return (int[][])arr.toArray(new int[0][]);
    }

    public int[][] merge1(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int L=intervals[i][0], R=intervals[i][1];
            if(merged.size()==0 || merged.get(merged.size()-1)[1] < L){
                merged.add(new int[]{L, R});
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int res[][] = new int[intervals.length][2];
        int idx = -1;
        for(int interval[] : intervals){
            // 如果结果数组是空的，或者当前区间的起始位置>结果数组中最后区间的终止位置，说明不重叠。
            // 则不合并，直接将当前区间加入结果数组。
            if(idx == -1 || interval[0]>res[idx][1]){
                res[++idx] = interval;
            }else{
                // 反之说明重叠，则将当前区间合并至结果数组的最后区间。
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }

    public static void main(String[] args) {
        int a[][]=new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        merge(a);
    }
}

class LeetCode56_1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if(index == -1 || intervals[i][0] > list.get(index)[1]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                index++;
            } else {
                list.add(new int[]{list.get(index)[0], Math.max(list.get(index)[1], intervals[i][1])});
                list.remove(index);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
