package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 做法
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }
}

/**
 * DFS 做法
 */
class LeetCode107_1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode node, int depth, List<List<Integer>> res) {
        if(node == null) {
            return;
        }
        if(depth == res.size()) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - depth - 1).add(node.val);
        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}
