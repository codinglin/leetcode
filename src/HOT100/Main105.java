package HOT100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main105 {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树的节点数目
        int size_left_subtree = inorder_root-inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从左边界+1开始的size_left_subtree」个元素就对应了中序遍历中「从左边界开始到根节点定位-1」的元素
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root-1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n =preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
           indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }
}

class Main105_1{
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder){
        int n = preorder.length;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return toBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode toBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left>preorder_right){
            return null;
        }
        int preorder_root = preorder_left;
        int inorder_root = map.get(preorder[preorder_root]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int left_tree_size = inorder_root-inorder_left;
        // 建立左子树
        root.left=toBuildTree(preorder,inorder,preorder_left+1,preorder_left+left_tree_size, inorder_left, inorder_root-1);
        //建立右子树
        root.right=toBuildTree(preorder,inorder,preorder_left + left_tree_size + 1,preorder_right, inorder_root+1, inorder_right);
        return root;
    }
}

class Main105_2{
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder==null || preorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex=0;
        for(int i=1; i<preorder.length; i++){
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
