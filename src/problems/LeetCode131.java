package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode131 {
    /**
     * 回溯 + 动态规划预处理
     *      设 f(i,j) 表示 s[i..j] 是否为回文串，那么有状态转移方程：
     *
     * @param s
     * @return
     */
    boolean[][] f;
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int i){
        if(i == n){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if(f[i][j]){
                ans.add(s.substring(i, j+1));
                dfs(s, j+1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

/**
 * 回溯 + 记忆化搜索
 */
class LeetCode131_1{
    int[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s){
        n = s.length();
        f = new int[n][n];
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i){
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j){
        if(f[i][j] != 0){
            return f[i][j];
        }
        if(i >= j){
            f[i][j] = 1;
        }else if(s.charAt(i) == s.charAt(j)){
            f[i][j] = isPalindrome(s, i+1, j-1);
        }else{
            f[i][j] = -1;
        }
        return f[i][j];
    }
}

class LeetCode131_2 {
    boolean[][]  f;
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new LinkedList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int i) {
        if(i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < n; j++) {
            if(f[i][j]){
                path.add(s.substring(i, j+1));
                dfs(s, j+1);
                path.remove(path.size() - 1);
            }
        }
    }
}
