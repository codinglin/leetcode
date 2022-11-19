package NiukeTOP101;

public class BM33 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null){
            return null;
        }
        TreeNode temp = Mirror(pRoot.left);
        pRoot.left = Mirror(pRoot.right);
        pRoot.right = temp;
        return pRoot;
    }
}
