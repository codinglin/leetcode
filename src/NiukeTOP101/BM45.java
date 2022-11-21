package NiukeTOP101;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 单调队列
 */
public class BM45 {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(num.length == 0 || size == 0 || num.length < size){
            return ans;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.getLast()] < num[i]){
                queue.pollLast();
            }
            queue.add(i);    // 将当先元素的下标入队
            if(i - queue.getFirst() + 1 > size) queue.pop();    // 若队头元素不合法就弹出
            if(i >= size - 1) ans.add(num[queue.getFirst()]);    // 将窗口最大值加入结果数组
        }
        return ans;
    }

    public static void main(String[] args) {
        maxInWindows(new int[]{9, 10, 9, -7, -3, 8, 2, -6}, 5);
    }
}
