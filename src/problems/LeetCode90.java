package problems;

import java.util.*;

public class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> ans = new ArrayDeque<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, 0, nums.length, ret, ans);
        return ret;
    }

    private void dfs(int[] nums, boolean[] used, int begin, int length, List<List<Integer>> ret, Deque<Integer> ans) {
        ret.add(new ArrayList<>(ans));
        if(ans.size() == length){
            return;
        }
        for (int i = begin; i < length; i++) {
            if(used[i]){
                continue;
            }
            if(i > begin && nums[i] == nums[i-1] && !used[i]){
                continue;
            }
            used[i] = true;
            ans.add(nums[i]);
            dfs(nums, used, begin + 1, length, ret, ans);
            ans.removeLast();
            used[i] = false;
        }
    }
}
