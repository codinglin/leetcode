package NiukeTOP101;

import java.util.Arrays;
import java.util.Stack;

/**
 * 递归：
 *      step 1：先根据前序遍历第一个点建立根节点。
 *      step 2：然后遍历中序遍历找到根节点在数组中的位置。
 *      step 3：再按照子树的节点数将两个遍历的序列分割成子数组，将子数组送入函数建立子树。
 *      step 4：直到子树的序列长度为0，结束递归。
 */
public class BM40 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        int n = pre.length;
        int m = vin.length;
        if(n == 0 || m == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++) {
            if(pre[0] == vin[i]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(vin, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(vin, i+1, vin.length));
                break;
            }
        }
        return root;
    }
}

/**
 * 栈的方式
 */
class BM40_1{
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        int n = pre.length;
        int m = vin.length;
        if(n == 0 || m == 0){
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(pre[0]);
        TreeNode cur = root;
        for (int i = 1, j = 0; i < n; i++) {
            // 要么旁边这个是它的左节点
            if(cur.val != vin[j]){
                cur.left = new TreeNode(pre[i]);
                s.push(cur);
                cur = cur.left;
            }else{
                j++;
                // 弹出到符合的祖先
                while (!s.isEmpty() && s.peek().val == vin[j]){
                    cur = s.pop();
                    j++;
                }
                // 添加右节点
                cur.right = new TreeNode(pre[i]);
                cur = cur.right;
            }
        }
        return root;
    }
}
