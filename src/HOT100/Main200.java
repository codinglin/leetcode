package HOT100;

import java.util.Arrays;

public class Main200 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isUsed = new boolean[n][m];
        Arrays.fill(isUsed, false);
        int num=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isUsed[i][j]==false){
                    num++;
                    backstack(grid, isUsed, i, j, n, m);
                }
            }
        }
        return num;
    }

    void backstack(char[][] grid, boolean[][] isUsed, int i, int j, int n, int m){
        if(i>=m || i<0 || j>=n || j<0){
            return;
        }
        isUsed[i][j]=true;
        backstack(grid, isUsed, i+1, j, n, m);
        backstack(grid, isUsed, i-1, j, n, m);
        backstack(grid, isUsed, i, j+1, n, m);
        backstack(grid, isUsed, i, j-1, n, m);
    }

    public static void main(String[] args) {

    }
}
