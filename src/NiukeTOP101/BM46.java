package NiukeTOP101;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BM46 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length == 0 || k ==0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int j : input) {
            maxHeap.add(j);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        while (!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }
        return result;
    }
}
