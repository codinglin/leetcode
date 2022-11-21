package NiukeTOP101;

public class BM36 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root){
        if (root == null) return 0;
        int ldep = depth(root.left);
        if (ldep == -1) return -1;
        int rdep = depth(root.right);
        if (rdep == -1) return -1;
        int sub = Math.abs(ldep - rdep);
        if (sub > 1) return -1;
        return Math.max(ldep, rdep) + 1;
    }
}

class BM36_1 {
    //计算该子树深度函数
    public int deep(TreeNode root){
        //空节点深度为0
        if(root == null)
            return 0;
        //递归算左右子树的深度
        int left = deep(root.left);
        int right = deep(root.right);
        //子树最大深度加上自己
        return (left > right) ? left + 1 : right + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        //空树为平衡二叉树
        if (root == null)
            return true;
        int left = deep(root.left);
        int right = deep(root.right);
        //左子树深度减去右子树相差绝对值大于1
        if(left - right > 1 || left - right < -1)
            return false;
        //同时，左右子树还必须是平衡的
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}
