package JZOffer2;

/**
 * 若root是p,q的最近公共祖先，则只可能以以下情况之一：
 *  1. p 和 q 在 root 的子树中，且分列 root 的异侧（即分别在左、右子树中）；
 *  2. p = root ，且 q 在 root 的左或右子树中；
 *  3. q = root ，且 p 在 root 的左或右子树中；
 */
public class Main68II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){   // 如果树为空，直接返回null
            return null;
        }
        // 最近公共祖先的情况1:p或q直接为root,那么p或q就是所求
        // 这里具体又可以分为几种情况:(设定p == root, q == root同理):
        //      1.p与q均存在于root中,结论显然成立,返回p
        //      2.p存在但q不存在root中,返回存在的那个节点,返回p
        if(root == p || root == q){
            return root;
        }
        // 递归求出root左右子树中p与q的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 最近公共祖先的情况2:p与q分居root异侧
        // 这种情况就是左右两边各有一个p或q,root必定为所求
        if(left != null && right != null) {
            return root;
        }
        // left == null && right != null时,左边没有 右边有 的情况
        // 最近公共祖先就是右边找到的那个(注意是已经递归出栈将祖先找出来了!)
        if(left == null){
            return right;
        }
        // 同理
        if(right == null){
            return left;
        }
        // left == null && right == null时
        // root两边都找不到,root本身也不是p或q,root又不为null,定义返回null
        return root;
    }
}
