package problems;

import java.util.LinkedList;
import java.util.Queue;

// 深度优先搜索
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

// 广度优先搜索
class LeetCode112_1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode now = queueNode.poll();
            int temp = queueVal.poll();
            if(now.left == null && now.right == null){
                if(temp == sum) {
                    return true;
                }
                continue;
            }
            if(now.left != null) {
                queueNode.offer(now.left);
                queueVal.offer(temp + now.left.val);
            }
            if(now.right != null) {
                queueNode.offer(now.right);
                queueVal.offer(temp + now.right.val);
            }
        }
        return false;
    }
}
