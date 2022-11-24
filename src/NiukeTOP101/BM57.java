package NiukeTOP101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS
 */
public class BM57 {
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve (char[][] grid) {
        int n = grid.length;
        if(n == 0){
            return 0;
        }
        int m = grid[0].length;
        boolean[][] state = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(state[i][j] || grid[i][j] == '0'){
                    continue;
                }
                dfs(grid, state, i, j);
                count ++;
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] state, int i, int j) {
        if(grid[i][j] == '0' || state[i][j]){
            return;
        }
        if(grid[i][j] == '1' && !state[i][j]){
            state[i][j] = true;
        }
        if(i + 1 < grid.length){
            dfs(grid, state, i+1, j);
        }
        if(i - 1 >= 0){
            dfs(grid, state, i-1, j);
        }
        if(j + 1 < grid[0].length){
            dfs(grid, state, i, j+1);
        }
        if(j - 1 >= 0){
            dfs(grid, state, i, j-1);
        }
    }
}

/**
 * BFS
 */
class BM57_1{
    public int solve (char[][] grid) {
        int n = grid.length;
        if(n == 0){
            return 0;
        }
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 遇到 1 要将这个 1 及其相邻的 1 都置为 0
                if(grid[i][j] == '1'){
                    count ++;
                    grid[i][j] = '0';
                    // 记录后续BFS的坐标
                    Queue<Integer> q1 = new LinkedList<>();
                    Queue<Integer> q2 = new LinkedList<>();
                    q1.offer(i);
                    q2.offer(j);
                    // BFS
                    while (!q1.isEmpty()){
                        int row = q1.poll();
                        int col = q2.poll();
                        // 四个方向依次检查：不越界且为 1
                        if(row - 1 >= 0 && grid[row - 1][col] == '1'){
                            q1.offer(row - 1);
                            q2.offer(col);
                            grid[row - 1][col] = '0';
                        }
                        if(row + 1 < n && grid[row + 1][col] == '1'){
                            q1.offer(row + 1);
                            q2.offer(col);
                            grid[row + 1][col] = '0';
                        }
                        if(col - 1 >= 0 && grid[row][col - 1] == '1'){
                            q1.offer(row);
                            q2.offer(col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if(col + 1 < m && grid[row][col + 1] == '1'){
                            q1.offer(row);
                            q2.offer(col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
