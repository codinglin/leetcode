package HOT100;

import java.util.Deque;
import java.util.LinkedList;

public class Main739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for(int i=0; i<n-1; i++){
            // int max = temperatures[n-1];
            int maxIndex = 0;
            for(int j=i+1; j<=n-1; j++){
                if(temperatures[i]<temperatures[j]){
                    maxIndex=j-i;
                    break;
                }
            }
            answer[i]=maxIndex;
        }
        answer[n-1] = 0;
        return answer;
    }
}

class Main739_1{
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        for(int i=0; i<length; i++){
            int current = temperatures[i];
            if(current < 100){
                for(int j=i+1; j<length; j++){
                    if(temperatures[j] > current){
                        answer[i] = j-i;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

// 单调栈
class Main739_2{
    // 维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if(n==0){
            return null;
        }
        int[] answer = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<n; i++){
            while (stack.size()!=0 && temperatures[stack.peek()]<temperatures[i]){
                int index = stack.pop();
                answer[index] = i-index;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
    }
}
