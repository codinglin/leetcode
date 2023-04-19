package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode501 {
    List<Integer> answer = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
           mode[i] = answer.get(i);
        }
        return mode;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int x) {
        if(x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if(count == maxCount) {
            answer.add(base);
        }
        if(count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
}
