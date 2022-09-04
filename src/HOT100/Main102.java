package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main102 {
    private List<List<Integer>> lists = new ArrayList<>();

    private Queue<TreeNode> Queue = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return lists;
        }
        Queue.add(root);
        while (!Queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = Queue.size();
            for(int i=1; i<=currentLevelSize; ++i){
                TreeNode node = Queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    Queue.offer(node.left);
                }
                if(node.right!=null){
                    Queue.offer(node.right);
                }
            }
            lists.add(level);
        }
        return lists;
    }

    public static void main(String[] args) {
        String str = "[3,9,20,null,null,15,7]";
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

class Main102_1{
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root==null) return list;
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode root, int level){
        if(list.size()==level) list.add(new ArrayList<>());
        list.get(level).add(root.val);
        if(root.left!=null){
            dfs(root.left, level+1);
        }
        if(root.right!=null){
            dfs(root.right, level+1);
        }
        return;
    }
}
