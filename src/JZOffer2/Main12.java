package JZOffer2;

public class Main12 {
    public static boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == start) {
                    if(dfs(board, word, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int index, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        if(index == word.length() - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, index + 1,i + 1, j) || dfs(board, word, index + 1,i - 1, j) ||
                dfs(board, word, index + 1, i, j + 1) || dfs(board, word, index + 1, i , j - 1);
        board[i][j] = word.charAt(index);
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist(board, word);
    }
}
