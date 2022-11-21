package NiukeTOP101;

import java.util.ArrayList;

public class BM38 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return helper(root, o1, o2).val;
    }

    private TreeNode helper(TreeNode root, int o1, int o2) {
        if(root == null || root.val == o1 || root.val == o2){
            return root;
        }
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);
        //如果left为空，说明这两个节点在root结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null)
            return right;
        //同上
        if (right == null)
            return left;
        //如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        //我们只需要返回cur结点即可。
        return root;
    }
}
