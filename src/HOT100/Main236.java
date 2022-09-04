package HOT100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main236 {
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    /*
        存储父节点
            1.从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
            2.从p节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
            3.同样，再从q节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是p和q的深度最深的公共祖先，即LCA节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p!=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root){
        if(root.left!=null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}

/*
* 递归
* 若root是p,q的最近公共祖先，则只可能为以下情况之一
*   1.p和q在root的子树中，且分列root的异侧(即分别在左、右子树中).
*   2.p=root,且q在root的左或右子树中.
*   3.q=root,且p在root的左或右子树中.
* 终止条件:
*   1.当越过叶节点，则直接返回null.
*   2.当root等于p,q,则直接返回root.
* 递推工作:
*   1.开启递归左子节点，返回值记为left;
*   2.开启递归右子节点，返回值记为right;
* 返回值:
*   根据left和right，可展开为四种情况:
*   1.当left和right同时为空 ：说明root的左 / 右子树中都不包含 p,q，返回 null;
*   2.当left和right同时不为空 ：说明 p, q分列在 root的 异侧 （分别在 左 / 右子树），因此root为最近公共祖先，返回 root；
*   3.当left为空,right不为空 ：p,q都不在root的左子树中，直接返回right。具体可分为两种情况：
        p,q其中一个在root的右子树 中，此时right指向 p（假设为 p）；
        p,q两节点都在root的右子树 中，此时的right指向 最近公共祖先节点 ；
    4.当left不为空 ，right为空 ：与情况 3. 同理；
* */
class Main236_1{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        // 如果p,q为根节点，则公共祖先为根节点
        if(root.val==p.val || root.val==q.val)
            return root;
        // 如果p,q在左子树，则公共祖先在左子树查找
        if(find(root.left, p) && find(root.left, q)){
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果p,q在右子树，则公共祖先在右子树查找
        if(find(root.right, p) && find(root.right, q)){
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果p,q分属两侧，则公共节点为根节点
        return root;
    }

    private boolean find(TreeNode root, TreeNode c){
        if(root == null) return false;
        if(root.val==c.val){
            return true;
        }
        return find(root.left, c) || find(root.left,c);
    }
}
