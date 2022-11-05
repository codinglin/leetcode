package problems;

import java.util.*;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int length = candidates.length;
        if(length == 0){
            return res;
        }
        // 关键步骤
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, 0, candidates.length, used, target, path, res);
        return res;
    }

    private void backtrack(int[] candidates, int begin, int length, boolean[] used, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(used[begin]){
            used[begin] = false;
            path.add(candidates[begin]);
            backtrack(candidates, begin + 1, length, used, target - candidates[begin], path, res);
            path.removeLast();
            used[begin] = true;
        }
    }
}
