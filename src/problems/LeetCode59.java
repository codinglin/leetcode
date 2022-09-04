package problems;

public class LeetCode59 {
    public static int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int visited[][] =new int[n][n];
        int m = n*n;
        int direction[][] = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int row=0, col=0, nextrow, nextcol, d=0;
        for(int i=1; i<=m; i++){
            matrix[row][col]=i;
            visited[row][col]=1;
            nextrow = row + direction[d][0];
            nextcol = col + direction[d][1];
            if(nextrow<0 || nextrow>=n || nextcol<0 || nextcol>=n || visited[nextrow][nextcol]==1){
                d = (d+1) % 4;
            }
            row += direction[d][0];
            col += direction[d][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }
}
