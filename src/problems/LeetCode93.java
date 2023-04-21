package problems;

import java.util.*;

public class LeetCode93 {
    List<String> ans = new ArrayList<>();

    Deque<String> path = new ArrayDeque<>();

    int n;
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        if(n == 0) {
            return ans;
        }
        if (n < 4 || n > 12) {
            return ans;
        }
        dfs(s, 0);
        return ans;
    }

    private int judgeIfIpSegment(String s, int left, int right){
        int len = right - left + 1;
        if(len > 1 && s.charAt(left) == '0') {
            return -1;
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        if(res > 255) {
            return -1;
        }
        return res;
    }

    private void dfs(String s, int index) {
        if(index == n) {
            if(path.size() == 4) {
                ans.add(String.join(".", path));
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if(index + i >= n) {
                break;
            }
            int ipSegment = judgeIfIpSegment(s, index, index + i);
            if(ipSegment != -1) {
                path.addLast(ipSegment + "");
                dfs(s, index + i + 1);
                path.removeLast();
            }
        }
    }
}
