package problems;

public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        // 根节点不是 p 和 q 中的任意一个，那么就继续分别往左子树和右子树找 p 和 q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p 和 q 都没有找到，那就没有
        if (left == null && right == null) {
            return null;
        }
        // 左子树没有 p 也没有 q，就返回右子树的结果
        if (left == null) {
            return right;
        }
        // 右子树没有 p 也没有 q，就返回左子树的结果
        if(right == null) {
            return left;
        }
        // 左右子树都找到 p 和 q 了，那就说明 p 和 q 分别在左右两个子树上，所有此时的最近公共祖先就是 root
        return root;
    }
}
