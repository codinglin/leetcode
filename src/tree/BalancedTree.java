package tree;

import java.util.Random;

/**
 * 平衡二叉搜索树
 */
public class BalancedTree {
    private class BalancedNode {
        long val;
        long seed;
        int count;
        int size;
        BalancedNode left;
        BalancedNode right;

        BalancedNode(long val, long seed) {
            this.val = val;
            this.seed = seed;
            this.count = 1;
            this.size = 1;
            this.left = null;
            this.right = null;
        }

        BalancedNode leftRotate() {
            int prevSize = size;
            int currSize = (left != null ? left.size : 0) + (right.left != null ? right.left.size : 0) + count;
            BalancedNode root = right;
            right = root.left;
            root.left = this;
            root.size = prevSize;
            size = currSize;
            return root;
        }

        BalancedNode rightRotate() {
            int prevSize = size;
            int currSize = (right != null ? right.size : 0) + (left.right != null ? left.right.size : 0) + count;
            BalancedNode root = left;
            left = root.right;
            root.right = this;
            root.size = prevSize;
            size = currSize;
            return root;
        }
    }

    private BalancedNode root;
    private int size;
    private Random rand;

    public BalancedTree() {
        this.root = null;
        this.size = 0;
        this.rand = new Random();
    }

    public long getSize() {
        return size;
    }

    public void insert(long x) {
        ++size;
        root = insert(root, x);
    }

    public long lowerBound(long x) {
        BalancedNode node = root;
        long ans = Long.MAX_VALUE;
        while (node != null) {
            if (x == node.val) {
                return x;
            }
            if (x < node.val) {
                ans = node.val;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public long upperBound(long x) {
        BalancedNode node = root;
        long ans = Long.MAX_VALUE;
        while (node != null) {
            if (x < node.val) {
                ans = node.val;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public int[] rank(long x) {
        BalancedNode node = root;
        int ans = 0;
        while (node != null) {
            if (x < node.val) {
                node = node.left;
            } else {
                ans += (node.left != null ? node.left.size : 0) + node.count;
                if (x == node.val) {
                    return new int[]{ans - node.count + 1, ans};
                }
                node = node.right;
            }
        }
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
    }

    private BalancedNode insert(BalancedNode node, long x) {
        if (node == null) {
            return new BalancedNode(x, rand.nextInt());
        }
        ++node.size;
        if (x < node.val) {
            node.left = insert(node.left, x);
            if (node.left.seed > node.seed) {
                node = node.rightRotate();
            }
        } else if (x > node.val) {
            node.right = insert(node.right, x);
            if (node.right.seed > node.seed) {
                node = node.leftRotate();
            }
        } else {
            ++node.count;
        }
        return node;
    }
}
