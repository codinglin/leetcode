package NiukeTOP101;

public class BM35 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isCompleteTree(root.left)){
            return false;
        }
        if(depth(root.left) == depth(root.right) || depth(root.left) == depth(root.right) + 1){
            return true;
        }
        if(depth(root.right) > depth(root.left)){
            return false;
        }
        return isCompleteTree(root.right);
    }

    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
