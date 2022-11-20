package NiukeTOP101;

import java.util.ArrayList;
import java.util.Stack;

public class BM34 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    private int MIN = Integer.MIN_VALUE;

    public boolean isValidBST (TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val < MIN){
            return false;
        }
        MIN = root.val;
        return isValidBST(root.right);
    }

    /**
     * 非递归写法
     */
    public boolean isValidBST1(TreeNode root){
        //设置栈用于遍历
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode head = root;
        //记录中序遍历的数组
        ArrayList<Integer> sort = new ArrayList<Integer>();
        while(head != null || !s.isEmpty()){
            //直到没有左节点
            while(head != null){
                s.push(head);
                head = head.left;
            }
            head = s.pop();
            //访问节点
            sort.add(head.val);
            //进入右边
            head = head.right;
        }
        //遍历中序结果
        for(int i = 1; i < sort.size(); i++){
            //一旦有降序，则不是搜索树
            if(sort.get(i - 1) > sort.get(i))
                return false;
        }
        return true;
    }
}
