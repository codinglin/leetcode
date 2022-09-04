package HOT100;

import java.util.*;

public class Main107 {
    private List<List<Integer>> lists = new ArrayList<>();

    private Queue<TreeNode> Queue = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return lists;
        }
        Queue.add(root);
        while (!Queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = Queue.size();
            for(int i=1; i<=currentLevelSize; ++i){
                TreeNode node = Queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    Queue.offer(node.left);
                }
                if(node.right!=null){
                    Queue.offer(node.right);
                }
            }
            lists.add(level);
        }
        Collections.reverse(lists);
        return lists;
    }
}
