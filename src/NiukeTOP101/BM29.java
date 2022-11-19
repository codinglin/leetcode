package NiukeTOP101;

import java.util.Stack;

public class BM29 {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode node, int sum) {
        if(node == null){
            return false;
        }
        int target = sum - node.val;
        // 当当前节点为叶子节点并且目标路径存在时，返回 true
        if (node.left == null && node.right == null && target == 0) {
            return true;
        }
        // 对左右分支进行 dfs
        return dfs(node.left, target) || dfs(node.right, target);
    }
}

/**
 * 非递归解法
 */
class BM29_1{
    public boolean hasPathSum (TreeNode root, int sum) {
        //空节点找不到路径
        if(root == null)
            return false;
        //栈辅助深度优先遍历
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        //跟随s1记录到相应节点为止的路径和
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(root);
        s2.push(root.val);
        while(!s1.isEmpty()){
            //弹出相应节点
            TreeNode temp = s1.pop();
            //弹出到该点为止的当前路径和
            int cur_sum = s2.pop();
            //叶子节点且当前路径和等于sum
            if(temp.left == null && temp.right == null && cur_sum == sum)
                return true;
            //左节点及路径和入栈
            if(temp.left != null){
                s1.push(temp.left);
                s2.push(cur_sum + temp.left.val);
            }
            //右节点及路径和入栈
            if(temp.right != null){
                s1.push(temp.right);
                s2.push(cur_sum + temp.right.val);
            }
        }
        return false;
    }
}
