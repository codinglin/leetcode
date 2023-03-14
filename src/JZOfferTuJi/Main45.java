package JZOfferTuJi;

import java.util.LinkedList;
import java.util.Queue;

public class Main45 {
    Queue<TreeNode> queue = new LinkedList<>();
    public int findBottomLeftValue(TreeNode root) {
        queue.add(root);
        int left = 0;
        while (!queue.isEmpty()){
            int length = queue.size();
            left = queue.peek().val;
            for(int i = 0; i < length; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return left;
    }
}
