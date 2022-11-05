package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    // 左括号数量不大于n,我们可以放一个左括号，如果右括号数量小于左括号的数量，我们可以放一个右括号。
    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if(cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }
        if(open < max){
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(close < open){
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

/**
 * 暴力法
 */
class LeetCode22_1{
    public List<String> generateParenthesis(int n){
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result){
        if(pos == current.length){
            if(valid(current)){
                result.add(new String(current));
            }
        }else{
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current){
        int balance = 0;
        for (char c : current) {
            if(c == '('){
                ++balance;
            }else {
                --balance;
            }
            if(balance < 0){
                return false;
            }
        }
        return balance == 0;
    }
}
