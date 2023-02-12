package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode155 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public LeetCode155() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int val) {
        stack1.push(val);
        if(!stack2.isEmpty()) {
            stack2.push(Math.min(stack2.peek(), val));
        } else {
            stack2.push(val);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
