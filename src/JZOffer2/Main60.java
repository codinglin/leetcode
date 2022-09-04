package JZOffer2;

import java.util.*;

public class Main60 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }else{
                queue.offer(new int[]{num, count});
            }
        }

        int[] ret = new int[k];
        for(int i = 0; i<k; i++){
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
