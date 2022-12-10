package NiukeTOP101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BM96 {
    public static int minmumNumberOfHost (int n, int[][] startEnd) {
        // 排序，头相等的，尾从小到大
        // 头不相等的头从小到大
        Arrays.sort(startEnd,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return Integer.compare(((int[]) o1)[0], ((int[]) o2)[0]);
            }
        });
        // 默认升序
        int min=Integer.MIN_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(min);
        for(int i = 0;i < n;i++){
            // 只提供结束时间，如果当前的开始时间小于队首的结束时间，说明没空闲
            // 如果当前的开始时间大于队首的结束时间，说明可以空闲一个，队首出队
            if(queue.peek() <= startEnd[i][0]) {
                queue.poll();
            }
            queue.offer(startEnd[i][1]);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] startEnd = new int[][]{{2147483646,2147483647},{-2147483648,-2147483647},{2147483646,2147483647},{-2147483648,-2147483647},{2147483646,2147483647},{-2147483648,-2147483647},{2147483646,2147483647},{-2147483648,-2147483647},{2147483646,2147483647},{-2147483648,-2147483647}};
        minmumNumberOfHost(2, startEnd);
    }
}
