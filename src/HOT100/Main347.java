package HOT100;

import java.util.*;

public class Main347 {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i], map.get(nums[i])+1);
//            }else{
//                map.put(nums[i], 1);
//            }
//        }
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }else {
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


class Main347_1{
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> values = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qSort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    private void qSort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k){
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);
        int pivot = values.get(start)[1];
        int index = start;
        for(int i = start+1; i<=end; i++){
            if(values.get(i)[1] >= pivot){
                Collections.swap(values, index+1, i);
                index ++;
            }
        }
        Collections.swap(values, start, index);
        if(k <= index-start){
            qSort(values, start, index - 1, ret, retIndex, k);
        }else{
            for(int i = start; i <= index; i++){
                ret[retIndex++] = values.get(i)[0];
            }
            if(k > index - start + 1){
                qSort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
}
