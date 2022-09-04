package HOT100;

import java.util.Arrays;

public class Main221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==0 || m==0){
            return 0;
        }
        int maxMatrix = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='1'){
                    maxMatrix = Math.max(maxMatrix, 1);
                    int currentMaxSide = Math.min(n-i, m-j);
                    for(int k=1; k<currentMaxSide; k++){
                        // 判断新增的一行一列是否均为1
                        boolean flag = true;
                        if(matrix[i+k][j+k]=='0'){
                            break;
                        }
                        for(int h = 0; h < k; h++){
                            if(matrix[i+k][j+h]=='0' || matrix[i+h][j+k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            maxMatrix = Math.max(maxMatrix, k+1);
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxMatrix * maxMatrix;
        return maxSquare;
    }
}

class Main221_1{
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==0 || m==0){
            return 0;
        }
        int[][] dp = new int[n][m];
        int maxMatrix=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='1'){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    }
                    maxMatrix = Math.max(maxMatrix, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxMatrix * maxMatrix;
    }

    public static void main(String[] args) {
        Main221_1 main = new Main221_1();
        char[][] matrix = {{'0','1'},{'1','0'}};
        int x = main.maximalSquare(matrix);
    }
}
