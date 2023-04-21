package problems;

import java.util.*;

public class LeetCode39 {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return ret;
    }

    private void backtrack(int[] candidates, int index, int target) {
        if(target == 0){
            ret.add(new ArrayList<>(ans));
            return;
        }
        if(target < 0){
            target += candidates[index];
            ans.remove(ans.size() - 1);
            ans.add(candidates[index + 1]);
            backtrack(candidates, index + 1, target- candidates[index + 1]);
            ans.remove(ans.size() - 1);
        }
        ans.add(candidates[index]);
        backtrack(candidates, index, target - candidates[index]);
        ans.remove(ans.size() - 1);
    }
}

class LeetCode39_1{
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(length == 0){
            return res;
        }
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, length, target, path, res);
        return res;
    }

    /**
     *
     * @param candidates 候选数组
     * @param begin 搜索起点
     * @param length 冗余变量，是candidates李的属性，可以不传
     * @param target 没减去一个元素，目标值变下
     * @param path 从根结点到叶子结点的路径，是一个栈
     * @param res 结果集列表
     */
    private void dfs(int[] candidates, int begin, int length, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < length; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序
            if(target - candidates[i] < 0){
                break;
            }
            path.add(candidates[i]);
            dfs(candidates, i, length, target-candidates[i], path, res);
            path.removeLast();
        }
    }
}

class LeetCode39_2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> res = new ArrayDeque<>();
        dfs(candidates, ans, res, 0, target);
        return ans;
    }

    private void dfs(int[] candidates, List<List<Integer>> ans, Deque<Integer> res, int index, int target) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target - candidates[i] < 0) {
                break;
            }
            res.add(candidates[i]);
            dfs(candidates, ans, res, i, target - candidates[i]);
            res.removeLast();
        }
    }
}

class LeetCode39_3 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> res = new ArrayDeque<>();
        dfs(ans, res, candidates, target, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, Deque<Integer> res, int[] candidates, int target, int index) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target - candidates[i] < 0) {
                break;
            }
            res.add(candidates[i]);
            dfs(ans, res, candidates, target - candidates[i], i);
            res.removeLast();
        }
    }
}

