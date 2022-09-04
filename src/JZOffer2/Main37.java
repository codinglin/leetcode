package JZOffer2;

import java.util.Stack;

public class Main37 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int index = 0, length = asteroids.length;
        while (index < length){
            if(stack.isEmpty() || stack.peek() < 0 || asteroids[index] > 0){
                stack.push(asteroids[index]);
            }else if(stack.peek() <= -asteroids[index]){
                if(stack.pop() < -asteroids[index]){
                    continue;
                }
            }
            index++;
        }
        int[] ret = new int[stack.size()];
        for(int i = ret.length - 1; i >= 0; i--){
            ret[i] = stack.pop();
        }
        return ret;
    }
}
