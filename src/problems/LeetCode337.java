package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * f(o)表示选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和;
 * g(o)表示不选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和;
 *      当 o 被选中时，o 的左右孩子都不能被选中，故 o 被选中情况下子树上被选中点的最大权值和为 l 和 r 不被选中的最大权值和相加，即 f(o) = g(l) + g(r) + val
 *      当 o 不被选中时，o 的左右孩子可以被选中也可以不被选中。故 g(o) = max{f(l), g(l)} + max{f(r), g(r)}
 */
public class LeetCode337 {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }
}
