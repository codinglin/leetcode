package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> path = new ArrayList<>();
        int n = temperatures.length;
        if(n == 0) {
            return new int[]{};
        }
        int[] ans = new int[n];
        int end = 0;
        while (end < n) {
            while(path.size() > 0 && temperatures[end] > temperatures[path.get(path.size() - 1)]) {
                int prevIndex = path.remove(path.size() - 1);
                ans[prevIndex] = end - prevIndex;
            }
            path.add(end);
            end ++;
        }
        return ans;
    }
}
