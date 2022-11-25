package NiukeTOP101;

import java.util.ArrayList;

public class BM61 {
    //记录四个方向
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int n, m;

    // 深度优先搜索，返回最大单元格数
    public int dfs(int[][] matrix, int[][] dp, int i, int j){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        dp[i][j] ++;
        for (int k = 0; k < 4; k++) {
            int nexti = i + dirs[k][0];
            int nextj = j + dirs[k][1];
            //判断条件
            if(nexti >= 0 && nexti < n && nextj >= 0 && nextj < m && matrix[nexti][nextj] > matrix[i][j])
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, dp, nexti, nextj) + 1);
        }
        return dp[i][j];
    }

    public int solve(int[][] matrix){
        // 矩阵不为空
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int res = 0;
        n = matrix.length;
        m = matrix[0].length;
        // i,j 处的单元格拥有的最长递增路径
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 更新最大值
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        return res;
    }

}
