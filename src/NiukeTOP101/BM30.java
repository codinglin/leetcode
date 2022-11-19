package NiukeTOP101;

import java.util.ArrayDeque;
import java.util.Deque;

public class BM30 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = pRootOfTree;
        TreeNode dummy = new TreeNode(-1);
        TreeNode pre = dummy;
        while(!stack.isEmpty() || p != null){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                TreeNode cur = new TreeNode(node.val);
                cur.left = pre;
                pre.right = cur;
                pre = cur;
                p = node.right;
            }
        }
        dummy.right.left = null;
        return dummy.right;
    }
}

/**
 * 递归写法
 */
class BM30_1{
    // 返回的第一个指针，即为最小值，先定为null
    TreeNode head = null;
    // 中序遍历当前值的上一位，初值为最小值，先定为null
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            // 中序递归，叶子为空则返回
            return null;
        }
        // 首先递归到最左最小值
        Convert(pRootOfTree.left);
        // 找到最小值，初始化head和pre
        if(pre == null){
            head = pRootOfTree;
            pre = pRootOfTree;
        }
        // 当前节点与上一个节点建立连接，将pre设置为当前值
        else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }
}
