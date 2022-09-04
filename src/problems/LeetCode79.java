package problems;

public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        boolean flag = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                flag = check(board, visited, i, j, word, 0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k){
        if(board[i][j] != s.charAt(k)){
            return false;
        }else if(k == s.length()-1){
            return true;
        }
        visited[i][j] = true;
        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        for(int[] dir: directions){
            int newi = i + dir[0], newj = j + dir[1];
            if(newi>=0 && newi<board.length && newj>=0 && newj<board[0].length){
                if(!visited[newi][newj]){
                    boolean flag = check(board, visited, newi, newj, s, k+1);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}

class LeetCode79_1{
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean flag = check(board, visited, word, i, j, 0);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int k){
        if(board[i][j]!= word.charAt(k)){
            return false;
        }
        if(k==word.length()-1){
            return true;
        }
        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        visited[i][j]=true;
        boolean result = false;
        for(int[] dir : directions){
            int newi = i + dir[0], newj = j + dir[1];
            if(newi>=0 && newi<board.length && newj>=0 && newj<board[0].length){
                if(!visited[newi][newj]){
                    boolean flag = check(board, visited, word, newi, newj, k+1);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
