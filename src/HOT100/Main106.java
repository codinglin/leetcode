package HOT100;

import java.util.HashMap;
import java.util.Map;

public class Main106 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return toBuildTree(inorder, postorder, 0, n-1, 0, n-1);
    }

    public TreeNode toBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right){
        if(inorder_left>inorder_right){
            return null;
        }
        int postorder_root = postorder_right;
        int inorder_root = map.get(postorder[postorder_root]);
        TreeNode root = new TreeNode(postorder[postorder_root]);
        int left_tree_size = inorder_root-inorder_left;
        // 建立左子树
        root.left = toBuildTree(inorder, postorder, inorder_left, inorder_root-1, postorder_left, postorder_left+left_tree_size-1);
        // 建立右子树
        root.right = toBuildTree(inorder, postorder, inorder_root+1, inorder_right, postorder_left+left_tree_size,postorder_right-1);
        return root;
    }

    public static void main(String[] args) {
        Main106 main= new Main106();
        int[] inorder={9, 3, 15, 20, 7};
        int[] postorder={9, 15, 7, 20, 3};
        TreeNode root = main.buildTree(inorder,postorder);
    }
}
