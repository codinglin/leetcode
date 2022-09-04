package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main129 {
    List<Integer> list = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        int sum=0;
        for(int i: list){
            sum+=i;
        }
        return sum;
    }

    void dfs(TreeNode root, StringBuffer sb){
        if(root.left==null && root.right==null){
            sb.append(root.val);
            list.add(Integer.valueOf(sb.toString()));
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(root.val);
        if(root.left != null) dfs(root.left, sb);
        if(root.right != null) dfs(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        String str = "[4,9,0,5,1,null,null]";
        TreeNode root = mkTree(str);
        Main129 main = new Main129();
        int sum = main.sumNumbers(root);
        System.out.println(sum);
    }

    private static int[] StrToIntArray(String str){
        str = str.substring(1, str.length()-1);
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];
        for (int i=0; i<arr.length; i++){
            if(strs[i].equals("null")){
                arr[i] = Integer.MAX_VALUE;
            }else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }
        return arr;
    }

    private static TreeNode mkTree(String str){
        int[] arr = StrToIntArray(str);
        TreeNode[] nodes = new TreeNode[arr.length+1];
        for(int i=1; i< nodes.length; i++){
            if(arr[i-1] != Integer.MAX_VALUE){
                nodes[i] = new TreeNode(arr[i-1]);
            }else{
                nodes[i] = null;
            }
        }
        TreeNode node = null;
        for(int i=1; i< nodes.length/2; i++){
            node = nodes[i];
            if(node == null) continue;
            node.left=nodes[2*i];
            node.right=nodes[2*i+1];
        }
        return nodes[1];
    }
}


// 深度优先遍历
class Main129_1{
    public int sumNumbers(TreeNode root){
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum){
        if(root==null){
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if(root.left==null && root.right==null){
            return sum;
        }else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}


// 广度优先搜索
class Main129_2{
    public int sumNumbers(TreeNode root){
        if(root==null){
            return 0;
        }
        int sum=0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if(left == null && right == null){
                sum+=num;
            }else {
                if(left != null){
                    nodeQueue.offer(left);
                    numQueue.offer(num*10 + left.val);
                }
                if(right != null){
                    nodeQueue.offer(right);
                    numQueue.offer(num*10 + right.val);
                }
            }
        }
        return sum;
    }
}
