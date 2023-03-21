package JZOfferTuJi;

import java.util.ArrayList;
import java.util.List;

public class Main83 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>(), used);
        return ans;
    }

    private void dfs(int[] nums, ArrayList<Integer> res, boolean[] used) {
        if(res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                res.add(nums[i]);
                used[i] = true;
                dfs(nums, res, used);
                used[i] = false;
                res.remove(res.size() - 1);
            }
        }
    }
}
