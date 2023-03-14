package JZOffer2;

import java.util.*;

public class Main32 {
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.pollFirst();
            result.add(temp.val);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
