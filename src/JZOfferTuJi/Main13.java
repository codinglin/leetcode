package JZOfferTuJi;

public class Main13 {
    int[][] sums;

    public Main13(int[][] matrix) {
        int n = matrix.length;
        if(n > 0){
            int m = matrix[0].length;
            sums = new int[n][m+1];
            for(int i=0; i<n; i++){
                for(int j=1; j<=m; j++){
                    sums[i][j] = sums[i][j-1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            sum += sums[i][col2+1] - sums[i][col1];
        }
        return sum;
    }
}
