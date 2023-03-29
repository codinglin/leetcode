package HOT100;

import java.util.ArrayList;
import java.util.List;

public class Main78 {
    List<List<Integer>> res;
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(ans));
        for(int i = start; i < nums.length; i++){
            // 将当前数加入list
            ans.add(nums[i]);
            // 递归 不能重复使用当前数 因此下一轮从i+1开始
            dfs(nums, i+1);
            // 回溯 回退刚刚加的数
            ans.remove(ans.size()-1);
        }
    }
}
