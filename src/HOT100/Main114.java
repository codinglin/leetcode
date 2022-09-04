package HOT100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for(int i=1; i<size; i++){
            TreeNode prev = list.get(i-1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list){
        if(root != null){
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}

class Main114_1{
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                list.add(node);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
}

class Main114_2{
    public void flatten(TreeNode root){
        if(root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(prev!=null){
                prev.left=null;
                prev.right=curr;
            }
            TreeNode left=curr.left, right=curr.right;
            if(right!=null){
                stack.push(right);
            }
            if(left!=null){
                stack.push(left);
            }
            prev=curr;
        }
    }
}
