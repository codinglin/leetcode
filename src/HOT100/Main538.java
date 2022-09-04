package HOT100;

public class Main538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        sum = sumNode(root);
        prefixNode(root);
        return root;
    }

    private int sumNode(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = sumNode(root.left);
        int right = sumNode(root.right);
        return left + right+ root.val;
    }

    private void prefixNode(TreeNode root){
        if(root==null){
            return;
        }
        int sub = root.val;
        root.val = sum;
        sum -= sub;
        prefixNode(root.left);
        prefixNode(root.right);
    }
}

class Main538_1 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
