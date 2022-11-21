package NiukeTOP101;

import java.util.ArrayList;

public class BM37 {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        //求根节点到两个节点的路径
        ArrayList<Integer> path_p = getPath(root, p);
        ArrayList<Integer> path_q = getPath(root, q);
        int res = 0;
        //比较两个路径，找到第一个不同的点
        for(int i = 0; i < path_p.size() && i < path_q.size(); i++){
            int x = path_p.get(i);
            int y = path_q.get(i);
            //最后一个相同的节点就是最近公共祖先
            if(x == y)
                res = path_p.get(i);
            else
                break;
        }
        return res;
    }

    //求得根节点到目标节点的路径
    public ArrayList<Integer> getPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        TreeNode node = root;
        //节点值都不同，可以直接用值比较
        while(node.val != target){
            path.add(node.val);
            //小的在左子树
            if(target < node.val)
                node = node.left;
                //大的在右子树
            else
                node = node.right;
        }
        path.add(node.val);
        return path;
    }
}

class BM37_1{
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if(root == null) {
            return -1;
        }
        //pq在该节点两边说明这就是最近公共祖先
        if((p >= root.val && q <= root.val) || (p <= root.val && q >= root.val))
            return root.val;
            //pq都在该节点的左边
        else if(p <= root.val && q <= root.val)
            //进入左子树
            return lowestCommonAncestor(root.left, p, q);
            //pq都在该节点的右边
        else
            //进入右子树
            return lowestCommonAncestor(root.right, p, q);
    }
}
