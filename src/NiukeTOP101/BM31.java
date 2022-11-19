package NiukeTOP101;

public class BM31 {
    boolean isSymmetrical(TreeNode pRoot) {
        return recursion(pRoot, pRoot);
    }

    private boolean recursion(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return recursion(root1.left, root2.right) && recursion(root1.right, root2.left);
    }
}
