package NiukeTOP101;

import java.util.Stack;

public class BM43 {
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.size() == 0){
            minStack.push(node);
        }else{
            int min = minStack.peek();
            min = Math.min(min, node);
            minStack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
