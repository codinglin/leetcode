package problems;

/**
 * 如果 x 到不了 y + 1 (但能到 y)，那么从 x 到 y 的任一点出发都不可能到达 y + 1.
 * 也可以假设：从 x 加油站出发经过 z 加油站最远能到达 y 加油站，那么从 z 加油站直接出发，不可能到达 y 下一个加油站。
 *           因为从 x 出发到 z 加油站时还有存储的油，这都不能到达 y 的下一站，而直接从 z 出发刚开始是没有存储的油的，所以更不可能到达 y 的下一站
 */
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            // 总汽油量，总耗油量
            int sumOfGas = 0, sumOfCost = 0;
            // cnt 为经过加油站的数量
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if(sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if(cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
