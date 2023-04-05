package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1382 {
    List<Integer> inorderSeq = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, inorderSeq.size() - 1);
    }

    private TreeNode build(int left, int right) {
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(inorderSeq.get(mid));
        if(left <= mid - 1) {
            root.left = build(left, mid - 1);
        }
        if(right >= mid + 1) {
            root.right = build(mid + 1, right);
        }
        return root;
    }

    private void getInorder(TreeNode root) {
        if(root.left != null) {
            getInorder(root.left);
        }
        inorderSeq.add(root.val);
        if(root.right != null) {
            getInorder(root.right);
        }
    }
}
