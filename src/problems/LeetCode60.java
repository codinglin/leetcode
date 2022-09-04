package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode60 {
    // 记录数字是否使用过
    private boolean[] used;

    // 阶乘数组
    private int[] factorial;

    private int n;
    private int k;

    /*
    * 回溯搜索算法+剪枝，直接来到叶子结点
    * 基于以下几点考虑：
    * 所求排列一定在叶子节点处得到，进入每一个分支，可以根据已经选定的数的个数，
    * 进而计算还未选定的数的个数，然后计算阶乘，就知道这一个分支的叶子结点的个数：
    *   如果k大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫剪枝
    *   如果k小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。
    * */
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;

        calculateFactorial(n);

        // 查找全排列需要的布尔数组
        used = new boolean[n+1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }

    /*
    *   例子 n=4, k=9
    *   所求排列一定在叶子节点处得到。
    *   事实上，进入每一个分支的时候，我们都可以通过递归的层数，直接计算着以分支可以得到的叶子结点的个数。
    *   以[1, 2, 3, 4]为例。
    *   第一层，以1开头，后面有三个数[2,3,4]可选。
    *   以1开头的全排列一共有3!=6个，并且6<k=9,因此，所求的全排列一定不以1开头，可以在这里“剪枝”。
    * */

    /**
     * 深搜
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param path
     */
    private void dfs(int index, StringBuilder path){
        if(index == n){
            return;
        }

        // 计算还未确定的数字的全排列的个数，第1次进入的时候是n-1
        int cnt = factorial[n - 1 - index];
        for(int i=1; i<=n; i++){
            if(used[i]){
                continue;
            }
            if(cnt < k){
                k-=cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index+1, path);
            /*
                注意1: 不可以回溯(重置变量)，算法设计是[一下子来到叶子结点]，没有回头的过程
                注意2: 这里要加return,后面的数没有必要遍历去尝试了
            */
            return;
        }
    }

    /**
     * 计算阶乘数组
     * @param n
     */
    private void calculateFactorial(int n) {
        factorial = new int[n+1];
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            factorial[i] = factorial[i-1] * i;
        }
    }

    /*
    *  有序数组(链表)模拟
    *  以n=4,k=6为例，现在确定第一个数字。
    *  如果第k个数恰好是后面的数字个数的阶乘，那么第1个数字就只能填最小的1。
    *  如果n=4,k=16,现在确定第一个数字。
    *  如果k > 后面的数字个数的阶乘。数一数，可以跳过几个阶乘数。
    *  算法流程设计：
    *       把候选数放在一个有序列表里，从左到右根据【剩下的数的阶乘数】确定每一位填谁，
    *   公式k/(后面几位的阶乘数)的值恰好等于候选数组的下标；
    *   选出一个数以后，k就需要减去相应跳过的阶乘数的倍数；
    *   已经填好的数需要从候选列表里删除，主义保持序列的有序性(因为排列的定义是按照字典序);
    *   由于这里考虑的是下标，第k个数，下标为k-1,一开始的时候，k--;
    *
    *  每次选出一个数，就将这个数从列表里面拿出。这个列表需要支持频繁的删除操作，因此使用双链表。在 Java 中 LinkedList 就是使用双链表实现的。
    *
    *
    *  以n=4,k=9为例。
    *   在[1, 2, 3, 4]里选第1个数，3!=6, 8/6 = 1,选下标为1的数2，k-6=2,从列表里删除下标为1的元素。
    *   在[1, 3, 4]里选第2个数,2!=2, 2/2 = 1,选下标为1的数3,k-2=0,从列表中删除下标为1的元素。
    *   在[1, 4]里选第3个数,1!=1,0/1=0,选下标为0的数1，k-0=0，从列表中删除下标为0的元素。
    *   在[4]里选第1个数,0!=1,0/1=0，选下标为0的数4,k-0=0,从列表里删除下标为0的元素。
    * */
    public String getPermutation1(int n, int k) {
        // 注意：相当于在 n 个数字的全排列中找到下标为 k - 1 的那个数，因此 k 先减 1
        k --;

        int[] factorial = new int[n];
        factorial[0] = 1;
        // 先算出所有的阶乘值
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // 这里使用数组或者链表都行
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        // i 表示剩余的数字个数，初始化为 n - 1
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i] ;
            stringBuilder.append(nums.remove(index));
            k -= index * factorial[i];
        }
        return stringBuilder.toString();
    }

}
