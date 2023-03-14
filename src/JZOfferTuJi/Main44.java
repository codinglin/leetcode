package JZOfferTuJi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main44 {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < length; i++){
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
