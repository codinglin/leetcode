package JZOffer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        int num = 0;
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            num = (num + 1) % 2;
            for(int i = queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(num == 0){
                    tmp.add(0, node.val);
                }else{
                    tmp.add(node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
