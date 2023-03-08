package HOT100;

import java.util.ArrayList;
import java.util.List;

public class Main22 {
    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        backtrace(new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrace(StringBuilder sb, int open, int close, int max) {
        if(sb.length() == max * 2) {
            ans.add(String.valueOf(sb));
            return;
        }
        if(open < max) {
            sb.append('(');
            backtrace(sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open) {
            sb.append(')');
            backtrace(sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
