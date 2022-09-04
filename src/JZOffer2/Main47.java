package JZOffer2;

import java.util.Deque;
import java.util.LinkedList;

public class Main47 {
    public TreeNode pruneTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> mark = new LinkedList<>(); // 使用辅助栈
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            while (!mark.isEmpty() && mark.peek() == stack.peek()){
                TreeNode cur = stack.pop();
                if(mark.pop().val == 0 && cur.left == null && cur.right == null){
                    if(!stack.isEmpty()){
                        TreeNode tmp = stack.peek();
                        if(tmp.left == cur){
                            tmp.left = null;
                        }else{
                            tmp.right = null;
                        }
                    } else{
                        return null;
                    }
                }
            }
            if(!stack.isEmpty()){
                node = stack.peek();
                mark.push(node);
                node = node.right;
            }
        }
        return root;
    }
}

class Main47_1{
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null){
            root = null;
        }
        return root;
    }
}