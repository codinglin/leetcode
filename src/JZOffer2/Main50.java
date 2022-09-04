package JZOffer2;

import java.util.HashMap;

public class Main50 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum){
        int ret = 0;
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}

class Main50_1{
    public int pathSum(TreeNode root, int targetSum){
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, HashMap<Long, Integer> prefix, long curr, int targetSum) {
        if(root == null){
            return 0;
        }
        int ret = 0;
        curr += root.val;
        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return ret;
    }
}
