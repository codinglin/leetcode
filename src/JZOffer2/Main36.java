package JZOffer2;

import java.util.Deque;
import java.util.LinkedList;

public class Main36 {
    public DoubleNode treeToDoublyList(DoubleNode root) {
        if(root == null){
            return null;
        }
        Deque<DoubleNode> stk = new LinkedList<DoubleNode>();
        DoubleNode pre= null, head = null;
        while(root != null || ! stk.isEmpty()){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            root.left = pre;
            if(pre != null){
                pre.right = root;
            }else{
                head = root;
            }
            pre = root;
            root = root.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}

class DoubleNode {
    public int val;
    public DoubleNode left;
    public DoubleNode right;

    public DoubleNode() {}

    public DoubleNode(int _val) {
        val = _val;
    }

    public DoubleNode(int _val,DoubleNode _left,DoubleNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
