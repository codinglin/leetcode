package HOT100;

import java.util.ArrayList;
import java.util.List;

public class Main301 {
    private List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int lRemove = 0;
        int rRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                lRemove++;
            } else if(s.charAt(i) == ')') {
                if(lRemove == 0) {
                    rRemove++;
                } else {
                    lRemove--;
                }
            }
        }
        helper(s, 0, lRemove, rRemove);
        return res;
    }

    private void helper(String str, int start, int lRemove, int rRemove) {
        if(lRemove == 0 && rRemove == 0) {
            if(isValid(str)) {
                res.add(str);
            }
        }
        for (int i = start; i < str.length(); i++) {
            if(i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lRemove + rRemove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lRemove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lRemove - 1, rRemove);
            }
            // 尝试去掉一个右括号
            if (lRemove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lRemove, rRemove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}
