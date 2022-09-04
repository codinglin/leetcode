package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        int L = newInterval[0], R = newInterval[1];
        int i=0;
        while(i<n && intervals[i][1]<L){
            merged.add(intervals[i++]);
        }

        while(i<n && intervals[i][0] <= R){
            L = Math.min(intervals[i][0],L);
            R = Math.max(intervals[i][1],R);
            i++;
        }
        merged.add(new int[]{L, R});
        while(i<n){
            merged.add(intervals[i++]);
        }

//        int a = 0, b = 0;
//        boolean flag = false;
//        for(int i=0;i<n;i++){
//            if(intervals[i][1] < L || intervals[i][0] > R){
//                merged.add(intervals[i]);
//                continue;
//            }
//            if(intervals[i][1] >= L){
//                if(!flag)
//                    a = Math.min(intervals[i][0], L);
//                flag = true;
//                continue;
//            }
//            if(intervals[i][0] <= R){
//                b = Math.max(intervals[i][1], R);
//                merged.add(new int[]{a, b});
//                flag = false;
//                continue;
//            }
//        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int newInterval[] = new int[]{4, 8};
        insert(intervals, newInterval);
    }
}
