package NiukeTOP101;

import java.util.ArrayList;
import java.util.Arrays;

public class BM54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int n = num.length, point = -1;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n && num[i] <= 0; i++) {
            if(point == num[i] && i != 0){
                continue;
            }
            point = num[i];
            ans.add(num[i]);
            int start = i + 1;
            int end = n - 1;
            int target = -point;
            while (start < end){
                if(num[start] + num[end] > target){
                    end --;
                }else if(num[start] + num[end] < target){
                    start ++;
                }else{
                    ans.add(num[start]);
                    ans.add(num[end]);
                    ret.add(new ArrayList<>(ans));
                    ans.clear();
                    ans.add(num[i]);
                    while(num[start]==num[start+1] && start+1<end) start++;
                    while(num[end]==num[end-1]&&end-1>start)end--;
                    start ++;
                    end --;
                }
            }
            ans.clear();
        }
        return ret;
    }
}
