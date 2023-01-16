package problems;

import java.util.*;

/**
 * 递归
 */
public class LeetCode951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    public static void main(String[] args) {
        TreeNode root1 = create();
        TreeNode root2 = create();
        LeetCode951 execute = new LeetCode951();
        execute.flipEquiv(root1, root2);
    }

    private static TreeNode create() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String substring = str.substring(1, str.length()-1);

        String[] strs = substring.split(",");//获取输入的字符串序列
        if (strs.length == 0) return  null;

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

/**
 * 让树中所有节点的左孩子都小于右孩子，如果当前不满足就翻转。我们把这种状态的二叉树称为 标准态。
 * 所有等价二叉树在转换成标准态后都是完全一样的。
 */
class LeetCode951_1 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> val1 = new ArrayList<>();
        List<Integer> val2 = new ArrayList<>();
        dfs(root1, val1);
        dfs(root2, val2);
        return val1.equals(val2);
    }

    private void dfs(TreeNode node, List<Integer> val) {
        if (node != null) {
            val.add(node.val);
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;
            if(L < R) {
                dfs(node.left, val);
                dfs(node.right, val);
            } else {
                dfs(node.right, val);
                dfs(node.left, val);
            }
            val.add(null);
        }
    }
}
