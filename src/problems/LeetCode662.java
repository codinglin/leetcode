package problems;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 广度优先遍历
 */
public class LeetCode662 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Pair<TreeNode, Integer> temp = queue.poll();
                TreeNode node = temp.getKey();
                Integer index = temp.getValue();
                if(node.left != null) {
                    queue.add(new Pair<>(node.left, index * 2));
                }
                if(node.right != null) {
                    queue.add(new Pair<>(node.right, index * 2 + 1));
                }
                size--;
            }
            if(!queue.isEmpty()){
                res = Math.max(res, queue.getLast().getValue() - queue.getFirst().getValue() + 1);
            }
        }
        return res;
    }
}

/**
 * 深度优先遍历
 */
class LeetCode662_1 {
    Map<Integer, Integer> levelMin = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode node, int depth, int index) {
        if(node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
