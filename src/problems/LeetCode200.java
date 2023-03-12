package problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS
 */
public class LeetCode200 {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int numIsLands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    numIsLands ++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIsLands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

/**
 * BFS
 */
class LeetCode200_1 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numIsLands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numIsLands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return numIsLands;
    }
}

/**
 * 扩展题：关于求岛屿中哪个岛屿面积最大的问题？
 */
class LeetCode_special {
    static int num = 0;
    public static int maxAreaOfIsland(int[][] grid) {
        /**
         * 只存值为1的元素是否访问
         */
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    continue;
                }
                if (isVisited[i][j]){
                    continue;
                }
                num = 0;
                int len = dfs(grid, i, j, isVisited);
                result = Math.max(len,result);
            }
        }
        return result;
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] isVisited) {
        int row = grid.length;
        int col = grid[0].length;
        if (isVisited[i][j]){
            return 0;
        }
        isVisited[i][j] = true;
        num++;
        //上
        if (i - 1 >= 0  && !isVisited[i - 1 ][j] && grid[i - 1][j] == 1){
            dfs(grid,i - 1 , j, isVisited);

        }
        //右
        if (j + 1 < col &&  !isVisited[i][j + 1] && grid[i][j + 1] == 1){
            dfs(grid,i , j + 1, isVisited);
        }
        //下
        if (i + 1 < row  && !isVisited[i + 1][j] && grid[i + 1][j] == 1){
            dfs(grid,i + 1, j, isVisited);
        }
        //左
        if (j - 1 >= 0  && !isVisited[i][j - 1] && grid[i][j -1] == 1){
            dfs(grid, i, j - 1 , isVisited);
        }
        return num;
    }
}
