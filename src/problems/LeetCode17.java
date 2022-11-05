package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    List<String> ans = new ArrayList<>();
    String[] str = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        dfs(0, digits, digits.length());
        return ans;
    }

    private void dfs(int index, String digits, int n){
        if(sb.length() == n){
            ans.add(new String(sb));
            return;
        }
        for (int i = 0; i < str[digits.charAt(index) - '2'].length(); i++) {
            sb.append(str[digits.charAt(index) - '2'].charAt(i));
            dfs(index + 1, digits, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
