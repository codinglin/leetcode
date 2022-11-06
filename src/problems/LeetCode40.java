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
        backtrack(candidates, 0, length, target, path, res);
        return res;
    }

    private void backtrack(int[] candidates, int begin, int length, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            // 大剪枝：减去candidate[i] 小于0，减去后面的 candidate[i+1]、candidate[i+2]肯定也小于0，因此用 break;
            if(target - candidates[i] < 0){
                break;
            }
            // 小剪枝：同一层相同数值的结点，从第2个开始，候选数更少，因此跳过，用continue
            if(i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            backtrack(candidates, i+1, length, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
