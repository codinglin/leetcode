package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res, ans, n, k, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> ans, int n, int k, int index) {
        if(ans.size() + (n - index + 1) < k || ans.size() > k) {
            return;
        }
        if(ans.size() == k) {
            int tempSum = 0;
            for (int sum : ans) {
                tempSum += sum;
            }
            if(n == tempSum) {
                res.add(new ArrayList<>(ans));
                return;
            }
        }
        for (int i = index; i <= 9 && k > 0; i++) {
            ans.add(i);
            dfs(res, ans, n, k, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}
