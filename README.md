# leetcode
个人刷题总结

刷题部分节选：

+ LeetCode 热门 100 题：[code](src/HOT100)
+ 牛客笔试 必刷 101 题：[code](src/NiukeTOP101)
+ 设计模式 java 实现：[code](src/designPattern)
+ 剑指 Offer 第一版：[code](src/JZOffer)
+ 剑指 Offer 第二版：[code](src/JZOffer2)

## 排序
快速排序（Quick Sort）， 归并排序（Merge Sort）的原理。

## 链表
链表这类的题，可以多考虑双指针、快慢指针、栈等方式。

## 树
### 二叉树：

前序遍历递归与非递归写法 [code](src/NiukeTop101/BM23.java)。

中序遍历递归与非递归写法 [code](src/NiukeTop101/BM24.java)。

后序遍历递归与非递归写法 [code](src/NiukeTop101/BM25.java)。

### 二叉搜索树
其中每个结点最多有两个子结点且具有二叉搜索树性质：左子树上所有结点的值均小于它的根结点的值以及右子树上所有结点的值均大于它的根结点的值。

### 平衡二叉树
它的左子树和右子树的高度之差(平衡因子)的绝对值不超过1且它的左子树和右子树都是一颗平衡二叉树。 
从上面简单的定义我们可以得出几个重要的信息： 平衡二叉树又称AVL树 平衡二叉树必须是二叉排序树。

### TreeMap
基于红黑树（平衡二叉搜索树）的一种树状 hashmap，增删查改、找求大最小均为 logN 复杂度。

### 字典树 (trie)
trie，又称前缀树或字典树，是一种有序树，用于保存关联数组，其中的键通常是字符串。
与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的位置决定。
一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串。
一般情况下，不是所有的节点都有对应的值，只有叶子节点和部分内部节点所对应的键才有相关的值。

## 堆、栈、队列、哈希表类
堆（Heap or Priority Queue）、栈（Stack）、队列（Queue）、哈希表类（Hashmap、Hashset）

## 回溯 [详细总结](src/summarize/backtrack.md)
回溯的本质是穷举所有可能，尽管有时候可以通过剪枝去除一些根本不可能是答案的分支， 但是从本质上讲，仍然是一种暴力枚举算法。

回溯法可以抽象为树形结构，并且是是一颗高度有限的树（N 叉树）。回溯法解决的都是在集合中查找子集，集合的大小就是树的叉树，递归的深度，构成树的高度。

## 搜索
分为宽度优先搜索 (BFS) 和 深度优先搜索 (DFS)。
* 常见的做法有：回溯 和 分治。

### BFS
* 常见的BFS用来解决什么问题？(1) 简单图（有向无向皆可）的最短路径长度，注意是长度而不是具体的路径（2）拓扑排序 （3） 遍历一个图（或者树）
* 
### DFS
* 常见的DFS用来解决什么问题？(1) 图中（有向无向皆可）的符合某种特征（比如最长）的路径以及长度（2）排列组合（3） 遍历一个图（或者树）（4）找出图或者树中符合题目要求的全部方案

## 前缀和
看到连续子串这类问题。

## 滑动窗口
单调队列的思想 [code](src/NiukeTop101/BM45.java)。

## 二分法 [详细总结](src/summarize/binary-search.md)
典型的是归并排序，利用二分思想。
二分查找：适用于有序递增或者递减的数组。
当然，解决很多题的时候，不一定需要整个数组都是有序的。

## 双指针
双指针指的是在遍历对象的过程中，不是普通的使用单个指针进行访问，而是使用两个指针（特殊情况甚至可以多个），两个指针或是同方向访问两个链表、或是同方向访问一个链表（快慢指针）、或是相反方向扫描（对撞指针），从而达到我们需要的目的。

例如逆序对 [code](src/NiukeTop101/BM20.java)，峰值数，或者是旋转数组的最小值。
例如对于求解峰值数 [code](src/NiukeTop101/BM19.java)，只需要保证峰值的左边是递增的，峰值数的右边是递减的即可。旋转数组的最小值 [code](src/NiukeTop101/BM21.java)也是同样的道理，因为它的左边和它的右边都是递增的。
亦或者是一种归并排序的方法，参见 [MergeSort](src/NiukeTop101/MergeSort.java)。

## 单调栈 [详细总结](src/summarize/monotone-stack.md)
单调栈实际上就是栈，只是利用了一些巧妙的逻辑，使得每次新元素入栈后，栈内的元素都保持有序（单调递增或单调递减）。

## 贪心
在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是最好或最优的算法。

## 动态规划 [详细总结](src/summarize/dynamic-programming.md)
具有最优子结构。例如一些背包问题。

## 并查集
并查集是一种数据结构，用于处理一些不交集（Disjoint sets，一系列没有重复元素的集合）的合并及查询问题。并查集支持如下操作：

* 查询：查询某个元素属于哪个集合，通常是返回集合内的一个“代表元素”。这个操作是为了判断两个元素是否在同一个集合之中。
* 合并：将两个集合合并为一个。
* 添加：添加一个新集合，其中有一个新元素。添加操作不如查询和合并操作重要，常常被忽略。

## 位运算
需要用到或运算、与运算等降低计算复杂度。

## 随机抽样
大数据流中的随机抽样问题

即：当内存无法加载全部数据时，如何从包含未知大小的数据流中随机选取k个数据，并且要保证每个数据被抽取到的概率相等。

**当 k = 1 时，** 也就是说，我们每次只能读一个数据。
假设数据流含有N个数，我们知道如果要保证所有的数被抽到的概率相等，那么每个数抽到的概率应该为 1/N。

那如何保证呢？

方案：每次只保留一个数，当遇到第i个数时，以 1/i 的概率保留它， (i-1)/i的概率保留原来的数。

举例说明： 1 - 10

* 遇到1，概率为1，保留第一个数。
* 遇到2，概率为1/2，这个时候，1和2各1/2的概率被保留
* 遇到3，3被保留的概率为1/3，(之前剩下的数假设1被保留)，2/3的概率 1 被保留，(此时1被保留的总概率为 2/3 * 1/2 = 1/3)
* 遇到4，4被保留的概率为1/4，(之前剩下的数假设1被保留)，3/4的概率 1 被保留，(此时1被保留的总概率为 3/4 * 2/3 * 1/2 = 1/4)
以此类推，每个数被保留的概率都是1/N。

证明使用数学归纳法即可。

**当 k=m 时**，也就是说，每次能读取m个数据。和上面相同的道理，只不过概率在每次乘以m而已。
![img.png](src/image/img1.png)
