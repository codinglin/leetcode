# 动态规划
## 背包问题总结
### 0-1 背包
* 目标和：转换问题为 0-1 背包方案数问题，[code](../HOT100/Main494.java).
* 分割等和子集：转换后 0-1 背包可行性问题。[code](../HOT100/Main416.java).
* 最后一块石头的重量II：转化为 0-1 背包最小值问题。[code](../problems/LeetCode1049.java).
### 完全背包
* 零钱兑换：完全背包最小值。[code](../problems/LeetCode322.java).
* 完全平方数：完全背包最小值。[code](../problems/LeetCode279.java).
* 组合总和IV：考虑物品顺序的完全背包方案书。每个物品可以重复拿，有几种装满背包的方案？[code](../problems/LeetCode377.java).
### 多维背包
* 01 字符构成最多的字符串：多维费用的 0-1 背包最大值，两个背包大小：0和1的数量。[code](../problems/LeetCode474.java).
* 盈利计划：多维费用的 0-1 背包最大值。[code](../problems/LeetCode879.java).
### 分组背包
* 掷骰子的N种方法：每一组是一个骰子，每个骰子只能拿一个体积为 1到6 的物品。[code](../problems/LeetCode1155.java).

## 常见例题
[674. 最长连续递增序列](../problems/LeetCode674.java)

[1143. 最长公共子序列](../problems/LeetCode1143.java) (前缀型dp)

[300. 最长递增子序列](../problems/LeetCode300.java) (接龙型dp)

[368. 最大整除子集](../problems/LeetCode368.java) (接龙型dp)