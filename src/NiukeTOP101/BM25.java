
package NiukeTOP101;

import java.util.*;

public class BM25 {
    public int[] postorderTraversal (TreeNode root) {
        //添加遍历结果的数组
        List<Integer> list = new ArrayList();
        //递归前序遍历
        postorder(root, list);
        //返回的结果
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if(root != null){
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);
        }
    }
}

class BM25_1{
    public int[] postorderTraversal (TreeNode root) {
        //添加遍历结果的数组
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root != null || !s.isEmpty()){
            //每次先找到最左边的节点
            while(root != null){
                s.push(root);
                root = root.left;
            }
            //弹出栈顶
            TreeNode node = s.pop();
            //如果该元素的右边没有或是已经访问过
            if(node.right == null || node.right == pre){
                //访问中间的节点
                list.add(node.val);
                //且记录为访问过了
                pre = node;
            }else{
                //该节点入栈
                s.push(node);
                //先访问右边
                root = node.right;
            }
        }
        //返回的结果
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
