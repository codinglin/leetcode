package problems;

public class LeetCode778 {
    /**
     * 根据题目中的描述：
     * 如果等待的时间 t 越少，网格上可以游泳的部分就越少，存在从左上角到右下角的一条路径的可能性越小；
     * 如果等待的时间 t 越多，网格上可以游泳的部分就越多，存在从左上角到右下角的一条路径的可能性越大。
     *
     * 这是本问题具有的 单调性。因此可以使用二分查找定位到最短等待时间。具体来说：在区间 [0, N * N - 1] 里猜一个整数，
     * 针对这个整数从起点（左上角）开始做一次深度优先遍历或者广度优先遍历。
     *
     * 当小于等于该数值时，如果存在一条从左上角到右下角的路径，说明答案可能是这个数值，也可能更小；
     * 当小于等于该数值时，如果不存在一条从左上角到右下角的路径，说明答案一定比这个数值更大。
     * 按照这种方式不断缩小搜索的区间，最终找到最少等待时间。
     * @param grid
     * @return
     */
    private int N;

    public static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        this.N = grid.length;

        int left = 0;
        int right = N * N - 1;
        while (left < right) {
            // left + right 不会溢出
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[N][N];
            if (grid[0][0] <= mid && dfs(grid, 0, 0, visited, mid)) {
                // mid 可以，尝试 mid 小一点是不是也可以呢？下一轮搜索的区间 [left, mid]
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 使用深度优先遍历得到从 (x, y) 开始向四个方向的所有小于等于 threshold 且与 (x, y) 连通的结点
     *
     * @param grid
     * @param x
     * @param y
     * @param visited
     * @param threshold
     * @return
     */
    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, int threshold) {
        visited[x][y] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                if (newX == N - 1 && newY == N - 1) {
                    return true;
                }

                if (dfs(grid, newX, newY, visited, threshold)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
