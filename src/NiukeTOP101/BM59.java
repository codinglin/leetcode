package NiukeTOP101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BM59 {
    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    public int Nqueen (int n) {
        return solveNQueens(n).size();
    }

    public List<List<String>> solveNQueens(int n){
        char[][] chess = new char[n][n];
        // 初始化数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {
        // 终止条件，最后一行都走完了，说明找到了一组，把它加入到集合 res 中。
        if(row == chess.length){
            res.add(construct(chess));
            return;
        }
        // 判断每一张
        for (int col = 0; col < chess.length; col++) {
            // 判断这个位置是否可以放皇后
            if(valid(chess, row, col)){
                // 数组复制一份
                char[][] temp = copy(chess);
                // 在当前位置放个皇后
                temp[row][col] = 'Q';
                // 递归到下一行继续
                solve(res, temp, row+1);
            }
        }
    }

    //row表示第几行，col表示第几列
    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后,因为他是一行一行往下走的，
        //我们只需要检查走过的行数即可，通俗一点就是判断当前
        //坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //把二维数组chess中的数据测下copy一份
    private char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }

    //把数组转为list
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

}

/**
 * 递归与回溯
 */
class BM59_1{
    private int res;

    public int Nqueen(int n){
        res = 0;
        // 下标为行号，元素为列号，记录皇后位置
        int[] pos = new int[n];
        Arrays.fill(pos, 0);
        // 递归
        recursion(n, 0, pos);
        return res;
    }

    // 判断皇后是否符合条件
    public boolean isValid(int[] pos, int row, int col){
        // 遍历所有已经记录的行
        for (int i = 0; i < row; i++) {
            // 不能同行同列同一斜线
            if(row == i || col == pos[i] || Math.abs(row - i) == Math.abs(col - pos[i])){
                return false;
            }
        }
        return true;
    }

    private void recursion(int n, int row, int[] pos) {
        // 完成全部行都选择了位置
        if(row == n){
            res ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(pos, row, i)){
                pos[row] = i;
                recursion(n, row + 1, pos);
            }
        }
    }
}