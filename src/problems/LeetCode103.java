package problems;

import java.util.*;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int size = queue.size();
            while (size -- > 0) {
                TreeNode node = queue.poll();
                if(isOrderLeft) {
                    ans.add(node.val);
                } else {
                    ans.add(0, node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            isOrderLeft = !isOrderLeft;
            res.add(ans);
        }
        return res;
    }
}
