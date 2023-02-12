package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    // 模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> order = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return order;
        }
        int visited[][] = new int[n][m];
        int direction[][] = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int total = n*m;
        int row=0, col=0, nextrow, nextcol, d=0;
        for(int i=0; i<total;i++){
            order.add(matrix[row][col]);
            visited[row][col] = 1;
            nextrow = row + direction[d][0];
            nextcol = col + direction[d][1];
            if(nextrow<0 || nextrow>=n || nextcol<0 || nextcol>=m || visited[nextrow][nextcol]==1){
                d = (d+1) % 4;
            }
            row += direction[d][0];
            col += direction[d][1];
        }
        return order;
    }
}

class LeetCode54_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return order;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int visited[][] = new int[n][m];
        int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int total = n * m;
        int row = 0, colum = 0, nextRow = 0, nextColum = 0, d = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][colum]);
            visited[row][colum] = 1;
            nextRow = row + direction[d][0];
            nextColum = colum + direction[d][1];
            if(nextRow<0 || nextRow>=n || nextColum<0 || nextColum>=m || visited[nextRow][nextColum]==1){
                d = (d+1) % 4;
            }
            row += direction[d][0];
            colum += direction[d][1];
        }
        return order;
    }
}
