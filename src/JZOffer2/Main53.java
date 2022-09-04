package JZOffer2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main53 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, curr = root;
        while(!stack.isEmpty() || curr!=null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev == p){
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }
}
