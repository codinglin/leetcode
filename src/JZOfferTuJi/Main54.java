package JZOfferTuJi;

public class Main54 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        sumTree(root);
        buildTree(root);
        return root;
    }

    private void buildTree(TreeNode root) {
        if(root == null) {
            return;
        }
        buildTree(root.left);
        sum -= root.val;
        root.val += sum;
        buildTree(root.right);
    }

    private void sumTree(TreeNode root) {
        if(root == null) {
            return;
        }
        sum += root.val;
        sumTree(root.left);
        sumTree(root.right);
    }
}

/**
 * 反序中序遍历
 */
class Main54_1 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
