package JZOffer2;

public class Main12 {
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == start) {
                    if(dfs(board, word, 1, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        
        return false;
    }
}
