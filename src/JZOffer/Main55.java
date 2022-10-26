package JZOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度优先搜索
 */
public class Main55 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(dfs(root.left) + 1, dfs(root.right) + 1);
    }
}

/**
 * 广度优先搜索
 */
class Main55_1{
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
