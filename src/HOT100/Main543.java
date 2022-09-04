package HOT100;

public class Main543 {
    int maxd = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxd = depth(root);
        return maxd;
    }

    private int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        maxd = Math.max(left + right, maxd);
        return Math.max(left, right) + 1;
    }
}
