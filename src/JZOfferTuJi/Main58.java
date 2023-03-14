package JZOfferTuJi;

import java.util.Map;
import java.util.TreeMap;

public class Main58 {
    TreeMap<Integer, Integer> map;

    public Main58() {
         this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry1= map.floorEntry(start);
        Map.Entry<Integer, Integer> entry2= map.ceilingEntry(start);

        if (entry1 != null && entry1.getValue() > start) {
            return false;
        }
        if (entry2 != null && entry2.getKey() < end) {
            return false;
        }

        map.put(start, end);
        return true;
    }
}

/**
 * 普通的二叉搜索树 (BST) 只维护了一个元素值。
 * 这里让 BST 维护一个区间，即 (start, end),凡是比当前节点 start 更小的 end 所在区间应该在当前节点的左子树，
 * 凡是比当前节点的 end 更大的 start 所在区间应该在当前节点的右子树。
 * 这两种情况都不符合的区间即存在交集的区间，不应该被插入到树中。
 */
class MyCalendar{
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int start;
        int end;

        public TreeNode() {
        }

        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    TreeNode root;

    public MyCalendar(){

    }

    public boolean book(int start, int end){
        if(root == null){
            root = new TreeNode(start, end);
            return true;
        }
        // 类似二分搜索BST
        TreeNode p = root;
        while (p != null){
            if(end <= p.start){
                // 该区间应该在当前节点的左子树
                if(p.left == null){
                    // 若是左子树为空，那这就是应该插入的位置
                    p.left = new TreeNode(start, end);
                    return true;
                }
                p = p.left;
            }else if(start >= p.end){
                // 同理，该区间应该在该节点的右子树
                if(p.right == null){
                    p.right = new TreeNode(start, end);
                    return true;
                }
                p = p.right;
            }else{
                return false;
            }
        }
        return false;
    }
}
