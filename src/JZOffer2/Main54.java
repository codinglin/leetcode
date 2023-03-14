package JZOffer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main54 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty())
        {
            if(root != null){
                stack.push(root);
                root=root.left;
            }
            else{
                root = stack.pop();
                res.add(root.val);
                root=root.right;
            }
        }
        return res.get(res.size() - k);
    }
}
