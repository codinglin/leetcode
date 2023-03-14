package JZOffer2;

import java.util.Stack;

public class Main27_1 {
    public TreeNode mirrorType(TreeNode root){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>(){{add(root);}};
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
