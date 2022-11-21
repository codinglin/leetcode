package NiukeTOP101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BM41 {
    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode root = buildTree(xianxu, zhongxu);
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return new int[]{};
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                if(i == size - 1){
                    result.add(cur.val);
                }
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private TreeNode buildTree(int[] xianxu, int[] zhongxu) {
        int n = xianxu.length;
        int m = zhongxu.length;
        if(n == 0 || m == 0){
            return null;
        }
        TreeNode root = new TreeNode(xianxu[0]);
        for (int i = 0; i < zhongxu.length; i++) {
            if(xianxu[0] == zhongxu[i]){
                root.left = buildTree(Arrays.copyOfRange(xianxu, 1, i + 1), Arrays.copyOfRange(zhongxu, 0, i));
                root.right = buildTree(Arrays.copyOfRange(xianxu, i + 1, xianxu.length), Arrays.copyOfRange(zhongxu, i + 1, zhongxu.length));
                break;
            }
        }
        return root;
    }
}
