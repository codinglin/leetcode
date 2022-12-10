package NiukeTOP101;

public class BM99 {
    /**
     * step 1：遍历矩阵的下三角矩阵，将其与上三角矩阵对应的位置互换，其实就是数组下标交换后的互换。
     * step 2：遍历矩阵每一行，将每一行看成一个数组使用reverse函数翻转。
     */
    public int[][] rotateMatrix(int[][] mat, int n) {
        // 矩阵转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // //交换上三角与下三角对应的元素
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // 每行翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }
        return mat;
    }
}
