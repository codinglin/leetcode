package NiukeTOP101;

import java.util.ArrayList;

/**
 * 自己的方法
 */
public class BM98 {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int n = matrix.length;
        ArrayList<Integer> ret = new ArrayList<>();
        if(n == 0){
            return ret;
        }
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0, directMove = 0;
        int row = 0, col = 0;
        while (count < m*n){
            ret.add(matrix[row][col]);
            visited[row][col] = true;
            if(row + direction[directMove][0] > n-1 || col + direction[directMove][1] > m-1
                    || row + direction[directMove][0] < 0 || col + direction[directMove][1] < 0
                    || visited[row + direction[directMove][0]][col + direction[directMove][1]]){
                directMove ++;
                directMove %= 4;
            }
            row += direction[directMove][0];
            col += direction[directMove][1];
            count++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }
}
