package JZOffer2;

import java.util.LinkedList;
import java.util.List;

/**
 * 树的子结构
 * 1.先序遍历树A中的每个节点n_A：对应函数 isSubStructure(A, B)
 * 2.判断树A中以n_A为根节点的子树是否包含树B：对应函数 helper(root1, root2)
 *
 * helper(A, B) 函数：
 * 终止条件：
 *      当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true；
 *      当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false；
 *      当节点 A 和 B 的值不同：说明匹配失败，返回 false；
 *  返回值：
 *      判断 A 和 B 的左子节点是否相等，即 helper(A.left, B.left) ；
 *      判断 A 和 B 的右子节点是否相等，即 helper(A.right, B.right) ；
 * isSubStructure(A, B) 函数：
 *
 * 特例处理：当树 A 为空或树 B 为空时，直接返回 false ；
 * 返回值：若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
 *      以节点 A 为根节点的子树包含树 B，对应 helper(A, B)；
 *      树 B 是 树 A 左子树的子结构，对应 isSubStructure(A.left, B)；
 *      树 B 是 树 A 右子树的子结构，对应 isSubStructure(A.right, B)；
 */
public class Main26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        if(A.val == B.val && (helper(A.left, B.left) && helper(A.right, B.right))){
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
