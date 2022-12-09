# leetcode
个人刷题总结

刷题部分节选：

+ LeetCode 热门 100 题：[code](src/HOT100)
+ 牛客笔试 必刷 101 题：[code](src/NiukeTOP101)
+ 设计模式 java 实现：[code](src/designPattern)
+ 剑指 Offer 第一版：[code](src/JZOffer)
+ 剑指 Offer 第二版：[code](src/JZOffer2)

## 动态规划
具有最优子结构

## 回溯
解题步骤：1.画出树形图。 2.编码。 3.剪枝。
### 1. 什么时候使用 used 数组，什么时候使用 begin 变量
+ 排序问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组;
+ 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。

使用深度优先遍历有[回头]的过程，在[回头]以后，状态变量需要设置成为和先前一样，因此在回到上一层结点的过程中，需要撤销上一次的选择，这个操作称之为[状态重置];

深度优先遍历，借助系统栈空间，保存所需要的状态变量，在编码中只需要注意遍历到相应的结点的时候，状态变量的值是正确的，具体的做法是：往下走一层的时候，path 变量在尾部追加，而往回走的时候，需要撤销上一次的选择，也是在尾部操作，因此 path 变量是一个栈；
### 2. 解集不能包含重复的组合，那么如何去掉一个数组中重复的元素?

很容易想到的方案是：先对数组**升序**排序，重复的元素一定不是排好序以后相同的连续数组区域的第1个元素。

这个避免重复当思想是在是太重要了。
这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
![img.png](src/image/img.png)

为何会有这种神奇的效果呢？
首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
因为当第二个2出现的时候，他就和前一个2相同了。

那么如何保留例2呢？
那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
例2的两个2是处在不同层级上的。
在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.

### 3. 与动态规划的区别
用于求解多阶段决策问题。多阶段决策问题即：

**共同点**
* 求解一个问题分为很多步骤（阶段）;
* 每一个步骤（阶段）可以有多种选择。

**不同点**
* 动态规划只需要求我们评估最优解是多少，最优解对应的具体解是什么并不要求。因此很适合应用于评估一个方案的效果;
* 回溯算法可以搜索得到所有的方案（当然包括最优解），但是本质上它是一种遍历算法，时间复杂度很高。

## 贪心

## 前缀和

## 滑动窗口
单调队列的思想 [code](src/NiukeTop101/BM45.java)。

## 二分法
典型的是归并排序，利用二分思想。

二分查找：适用于有序递增或者递减的数组。

当然，解决很多题的时候，不一定需要整个数组都是有序的。

例如逆序对 [code](src/NiukeTop101/BM20.java)，峰值数，或者是旋转数组的最小值。
例如对于求解峰值数 [code](src/NiukeTop101/BM19.java)，只需要保证峰值的左边是递增的，峰值数的右边是递减的即可。旋转数组的最小值 [code](src/NiukeTop101/BM21.java)也是同样的道理，因为它的左边和它的右边都是递增的。

通用的代码模板：
```java
class Solution{
    public int search(int [] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = (left + right) / 2;
            //最小的数字在mid右边
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                return middle; // 数组中找到目标值，直接返回下标
            }
        }
        return -1;
    }
}
```

亦或者是一种归并排序的方法，参见 [MergeSort](src/NiukeTop101/MergeSort.java)。

## 链表
链表这类的题，可以多考虑双指针、快慢指针、栈等方式。

## 树
二叉树：

前序遍历递归与非递归写法 [code](src/NiukeTop101/BM23.java)。

中序遍历递归与非递归写法 [code](src/NiukeTop101/BM24.java)。

后序遍历递归与非递归写法 [code](src/NiukeTop101/BM25.java)。

## 排序数组的搜索问题
首先想到二分法

## 单调栈

## 双指针
双指针指的是在遍历对象的过程中，不是普通的使用单个指针进行访问，而是使用两个指针（特殊情况甚至可以多个），两个指针或是同方向访问两个链表、或是同方向访问一个链表（快慢指针）、或是相反方向扫描（对撞指针），从而达到我们需要的目的。

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

