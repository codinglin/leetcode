package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return null;
        }
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if(root == null) {
            return;
        }
        ans.add(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            if(targetSum == 0) {
                res.add(new ArrayList<>(ans));
            }
        }
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        ans.remove(ans.size() - 1);
    }
}
