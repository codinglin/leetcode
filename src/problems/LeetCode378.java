package problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 归并排序
 */
public class LeetCode378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = priorityQueue.poll();
            if (now[2] != n - 1) {
                priorityQueue.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return priorityQueue.poll()[0];
    }
}

class LeetCode378_1 {

}
