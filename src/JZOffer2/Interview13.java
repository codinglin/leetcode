package JZOffer2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度优先遍历
 */
public class Interview13 {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if(i >= m || j >= n || visited[i][j] || sumPosition(i) + sumPosition(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    private int sumPosition(int x){
        return (x % 10) + x / 10;
    }
}

/**
 * 广度优先遍历
 */
class Interview13_1 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1];
            if(i >= m || j >= n || visited[i][j] || sumPosition(i) + sumPosition(j) > k) {
                continue;
            }
            visited[i][j] = true;
            res ++;
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }
        return res;
    }

    private int sumPosition(int x){
        return (x % 10) + x / 10;
    }
}
