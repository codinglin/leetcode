package JZOffer2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main43 {
    private final TreeNode root;
    private final Queue<TreeNode> queue;
    private TreeNode index; // 标记父节点

    public Main43(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
            }
            /*
             *  完全二叉树:
             *      如果left为空，那么right也为空
             */
            if(node.right != null){
                queue.add(node.right);
            }else{
                index = node;
                break;
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        int res = index.val;
        if(index.left == null){
            index.left = node;
        }else if(index.right == null){
            index.right = node;
            index = queue.poll(); // 标记下一个父节点
        }
        queue.add(node);
        return res;
    }

    public TreeNode get_root() {
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
