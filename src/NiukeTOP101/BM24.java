package NiukeTOP101;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BM24 {
    public int[] inorderTraversal (TreeNode root) {
        //添加遍历结果的数组
        List<Integer> list = new ArrayList();
        //递归前序遍历
        inorder(root, list);
        //返回的结果
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if(root != null){
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }
}

class BM24_1{
    public int[] inorderTraversal (TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        //添加遍历结果的数组
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        //返回的结果
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
