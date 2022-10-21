package JZOffer;

public class Main28 {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    public boolean isSame(TreeNode root, TreeNode mirror){
        if(root == null && mirror == null){
            return true;
        }
        if(root == null || mirror == null){
            return false;
        }
        return root.val == mirror.val&&isSame(root.left, mirror.right) && isSame(root.right, mirror.left);
    }
}
