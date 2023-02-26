### 基本概念

树是一种非线性数据结构。树结构的基本单位是节点。节点之间的链接，称为分支（branch）。节点与分支形成树状，结构的开端，称为根（root），或根结点。根节点之外的节点，称为子节点（child）。没有链接到其他子节点的节点，称为叶节点（leaf）。如下图是一个典型的树结构：

每个节点可以用以下数据结构来表示：

```java
class TreeNode {
	int val; // 当前节点的值
	List<Node> children; // 指向其儿子
}
```

### 二叉树

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

### 例题：
[剑指Offer 55. 二叉树的深度](../JZOffer/Main55.java) (简单) 

[剑指Offer 34. 二叉树中和为某一值的路径](../JZOffer/Main34.java) (中等) 

[101. 对称二叉树](../problems/LeetCode101.java) (简单) 

[226. 翻转二叉树](../problems/LeetCode226.java) (简单) 

[543. 二叉树的直径](../problems/LeetCode543.java) (简单) 

[662. 二叉树最大宽度](../problems/LeetCode662.java) (中等) 

[971. 翻转二叉树以匹配先序遍历](../problems/LeetCode971.java) (中等) 

[236. 二叉树的最近公共祖先](../problems/LeetCode236.java) (中等) 

[98. 验证二叉搜索树](../problems/LeetCode98.java) (中等) 

[701. 二叉搜索树中的插入操作](../problems/LeetCode701.java) (中等) 

[110. 平衡二叉树](../problems/LeetCode110.java) (简单) 

[107. 二叉树的层序遍历II](../problems/LeetCode107.java) (中等) 

[124. 二叉树中的最大路径和](../problems/LeetCode124.java) (困难) 