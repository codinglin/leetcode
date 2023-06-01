package problems;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1472 {
    // 后退栈：存放历史页面（后退页面）和当前页面
    Deque<String> s1 = new LinkedList<>();
    // 前进栈：存放未来页面（前进页面）
    Deque<String> s2 = new LinkedList<>();
    public LeetCode1472(String homepage) {
        s1.push(homepage);
    }

    public void visit(String url) {
        s1.push(url);
        s2.clear();
    }

    public String back(int steps) {
        for (int i = 0; i < steps && s1.size() > 1; i++) {
            s2.push(s1.pop());
        }
        return s1.peek();
    }

    public String forward(int steps) {
        for (int i = 0; i < steps && !s2.isEmpty(); i++) {
            s1.push(s2.pop());
        }
        return s1.peek();
    }
}
