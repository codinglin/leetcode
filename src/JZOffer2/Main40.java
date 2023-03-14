package JZOffer2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Main40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int n = arr.length;
        if(n == 0){
            return new int[1];
        }
        if(k == 0){
            return new int[1];
        }
        PriorityQueue<Integer> maxHead = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            if(i<k){
                maxHead.add(arr[i]);
            }else{
                if(arr[i] < maxHead.peek()){
                    maxHead.poll();
                    maxHead.add(arr[i]);
                }
            }
        }
        int[] result = new int[k];
        int count = 0;
        while (!maxHead.isEmpty()){
            result[count++] = maxHead.poll();
        }
        return result;
    }

    class Main40_1{
        public int[] getLeastNumbers(int[] arr, int k) {
            randomizedSelected(arr, 0, arr.length - 1, k);
            int[] vec = new int[k];
            for(int i = 0; i < k; ++i){
                vec[i] = arr[i];
            }
            return vec;
        }

        private void randomizedSelected(int[] arr, int l, int r, int k) {
            if(l >= r){
                return;
            }
            int pos = randomizedPartition(arr, l, r);
            int num = pos - l + 1;
            if (k == num) {
                return;
            } else if (k < num) {
                randomizedSelected(arr, l, pos - 1, k);
            } else {
                randomizedSelected(arr, pos + 1, r, k - num);
            }
        }

        private int randomizedPartition(int[] nums, int l, int r) {
            int i = new Random().nextInt(r - l + 1) + 1;
            swap(nums, r, i);
            return partition(nums, l, r);
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; ++j) {
                if (nums[j] <= pivot) {
                    i = i + 1;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
