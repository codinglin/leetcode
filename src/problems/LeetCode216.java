package problems;

import java.util.ArrayList;
import java.util.LinkedList;
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

class LeetCode216_1 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) result.add(new ArrayList<>(path));
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }
}
