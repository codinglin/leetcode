package NiukeTOP101;

import java.util.LinkedList;
import java.util.Queue;

public class BM28 {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return max;
    }
}

/**
 * 层次遍历
 */
class BM28_1{
    public int maxDepth(TreeNode root){
        // 空节点没有深度
        if(root == null){
            return 0;
        }
        // 队列维护层次后续节点
        Queue<TreeNode> q = new LinkedList<>();
        // 根入队
        q.offer(root);
        // 记录深度
        int res = 0;
        // 层次遍历
        while (!q.isEmpty()){
            // 记录当前层有多少节点
            int n = q.size();
            // 遍历完这一层，再进入下一层
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                // 添加下一层的左右节点
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
