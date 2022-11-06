package problems;

import java.util.*;

public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        // 定义一个返回结果的集合
        List<List<String>> ret = new ArrayList<>();
        // 定义一个存储皇后的集合
        int[] queens = new int[n];
        // 填充queens数组的元素为-1
        Arrays.fill(queens, -1);
        //定义一个变量，来记录当前元素所在的列，并将他所在的列标记为不可放元素
        Set<Integer> columns = new HashSet<>();
        //定义一个变量，来记录当前元素所在的左对角线，并将他所在的左对角线标记为不可放元素
        Set<Integer> diagonals1= new HashSet<>();
        //定义一个变量，来纪律当前元素所在的右对角线，并将他所在的右对角线标记为不可放元素
        Set<Integer> diagonals2 = new HashSet<>();
        //深度优先搜索方法
        dfs(ret, queens, n, 0, columns,diagonals1,diagonals2);
        return ret;
    }

    private void dfs(List<List<String>> ret, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 如果当前遍历到最后一行，就说明存在一种解法
        // 所以将皇后的位置，存放入结果中
        if(row == n){
            // 用来将当前的N行N列中的元素所在的位置结果，转换格式
            List<String> board = generateBoard(queens, n);
            // 将符合条件的结果添加进返回的结果集中
            ret.add(board);
        }else{
            // 遍历所有行
            for (int i = 0; i < n; i++) {
                // 用来标记，当前行元素所在的列，都不可放元素。
                if(columns.contains(i)){
                    continue;
                }
                // 去除左对角线上的所有元素
                // row 表示行，i 表示列
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)){
                    continue;
                }
                // 经过上面的三次排除，就可以找到元素在当前行的哪一列的位置
                // 选第一行的第几列，也可以叫单元格所在的位置
                queens[row] = i;
                // 把选中的单元格加入到去除列的集合中
                // 用来给下一行的元素所在的列作为排除条件判断
                columns.add(i);
                // 把选中的单元格加入到去除左对角线的集合中
                diagonals1.add(diagonal1);
                // 把选中的单元格加入到去除右对角线的集合中
                diagonals2.add(diagonal2);
                // 递归遍历下一行
                dfs(ret,queens,n,row+1,columns,diagonals1,diagonals2);
                queens[row] = -1;
                //将当前列和左对角线和右对角线的元素都删除，避免重复遍历
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    //转换格式
    public List<String> generateBoard(int[] queens,int n){
        //定义一个结果集，用于返回结果
        List<String> board = new ArrayList<>();
        //遍历所有行
        for(int i = 0; i < n; i++){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            //将当前行所在的列的，位置置为Q
            row[queens[i]] = 'Q';
            //将当前结果添加进结果集中
            board.add(new String(row));
        }
        return board;
    }
}
