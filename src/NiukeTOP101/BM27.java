package NiukeTOP101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BM27 {
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(pRoot == null) {
            return ret;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode index = pRoot;
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(count % 2 == 1){
                ans.add(node.val);
            }else{
                ans.add(0, node.val);
            }
            if(node == index){
                ret.add(new ArrayList<>(ans));
                ans.clear();
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            if(node == index && !queue.isEmpty()){
                index = queue.getLast();
                count++;
            }
        }
        return ret;
    }

    /**
     * 将一个arry数组构建成一个完全二叉树
     * @param arr 需要构建的数组
     * @return 二叉树的根节点
     */
    public static TreeNode initBinTree(int[] arr) {
        if(arr.length == 1) {
            return new TreeNode(arr[0]);
        }
        List<TreeNode> nodeList = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == -1){
                nodeList.add(null);
            }else{
                nodeList.add(new TreeNode(arr[i]));
            }
        }
        int temp = 0;
        while(temp <= (arr.length - 2) / 2) {  //注意这里，数组的下标是从零开始的
            if(2 * temp + 1 < arr.length) {
                nodeList.get(temp).left = nodeList.get(2 * temp + 1);
            }
            if(2 * temp + 2 < arr.length) {
                nodeList.get(temp).right = nodeList.get(2 * temp + 2);
            }
            temp++;
        }
        return nodeList.get(0);
    }

    public static void main(String[] args) {
        TreeNode head = initBinTree(new int[]{3, 9, 20, -1, -1, 15, 7});
        Print(head);
    }
}
