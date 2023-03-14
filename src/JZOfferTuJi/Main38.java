package JZOfferTuJi;

import java.util.Stack;

public class Main38 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] position = new int[temperatures.length];
        int index = 0;
        while (index < temperatures.length){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[index]){
                int res = stack.pop();
                position[res] = index - res;
            }
            stack.push(index++);
        }
        return position;
    }
}
