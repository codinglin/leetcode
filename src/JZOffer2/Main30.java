package JZOffer2;

import java.util.LinkedList;

public class Main30 {
}

class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> aidStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        aidStack = new LinkedList<>();
    }

    public void push(int x) {
        if(!aidStack.isEmpty()){
            if(x <= aidStack.peek()){
                aidStack.push(x);
            }else{
                aidStack.push(aidStack.peek());
            }
        }else{
            aidStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            aidStack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return Integer.MAX_VALUE;
    }

    public int min() {
        if(!aidStack.isEmpty()){
            return aidStack.peek();
        }
        return Integer.MAX_VALUE;
    }
}
