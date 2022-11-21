package NiukeTOP101;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BM35 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 基本思路就是，将每层的节点以层序遍历的方式全部放入队列中（包括null）
     * 如果是完全二叉树，在我们取出节点的时候，应该是直到整棵树遍历完毕才会遇到null。
     * 所以当我们按层序遍历的方式，遇到null，但是队列中仍然存在节点，则代表不是完全二叉树；否则，是完全二叉树。
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        boolean notComplete = false;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if(cur == null){
                notComplete = true;
                continue;
            }
            if(notComplete){
                return false;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return true;
    }
}
