package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CreateTree {
    public static void main(String[] args) {
        TreeNode root = create();//建树
        preOrder(root);
        show(root);//前序遍历树
    }

    private static void show(TreeNode root){
        if (root == null) return;
        System.out.print(root.val+"  ");
        show(root.left);
        show(root.right);
    }

    static String preOrder(TreeNode root){
        StringBuffer sb = new StringBuffer();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null){
            return sb.toString();
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current != null){
                sb.append(current.val);
                stack.push(current.left);
                stack.push(current.right);
            }
        }
        return sb.toString();
    }


    public static TreeNode create() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String substring = str.substring(1, str.length()-1);

        String[] strs = substring.split(",");//获取输入的字符串序列
        if (strs.length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);
        int i=1;//记录序列遍历数量
        while (i<strs.length){
            int size = queue.size();//记录当前层次的节点数量
            for (int j = 0;j<size;j++){
                TreeNode t = queue.poll();
                if (i<strs.length&&!strs[i].equals("null")){
                    t.left = new TreeNode(Integer.parseInt(strs[i]));
                    queue.offer(t.left);//非空子树入队
                }
                i++;
                if (i<strs.length&&!strs[i].equals("null")){
                    t.right = new TreeNode(Integer.parseInt(strs[i]));
                    queue.offer(t.right);
                }
                i++;
            }
        }
        return  root;
    }
}
