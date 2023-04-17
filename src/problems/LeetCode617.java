package problems;

public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        int root1Value = root1 == null ? 0 : root1.val;
        int root2Value = root2 == null ? 0 : root2.val;
        int rootValue = root1Value + root2Value;
        TreeNode node = new TreeNode(rootValue);
        if(root1 == null) {
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        }else if(root2 == null) {
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        } else {
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }
        return node;
    }
}

class LeetCode617_1{
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
}
