package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 优先队列
 */
public class LeetCode973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < points.length; i++) {
            if(priorityQueue.size() < k) {
                priorityQueue.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
            } else {
                int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
                if (dist < priorityQueue.peek()[0]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{dist, i});
                }
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[priorityQueue.poll()[1]];
        }
        return ans;
    }
}

class LeetCode973_1 {
    Random random = new Random();

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        randomSelect(points, 0, n-1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void randomSelect(int[][] points, int left, int right, int k) {
        int pivotId = left + random.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, pivotId, right);
        int pointer = left;
        for (int i = left; i < right; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if(dist <= pivot) {
                swap(points, pointer++, i);
            }
        }
        swap(points, pointer, right);
        if (k < pointer - left + 1) {
            randomSelect(points, left, pointer - 1, k);
        } else if (k > pointer - left + 1) {
            randomSelect(points, pointer + 1, right, k - (pointer - left + 1));
        }
    }

    private void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
