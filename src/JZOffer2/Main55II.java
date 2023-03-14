package JZOffer2;

public class Main55II {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(dfs(root.left) + 1, dfs(root.right) + 1);
    }
}

class Main55II_1{
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        if(left == -1){
            return -1;
        }
        int right = dfs(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }else{
            return Math.max(left, right) + 1;
        }
    }
}
