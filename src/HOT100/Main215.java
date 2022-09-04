package HOT100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Main215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 转换一下，第k大元素的下标是len-k
        int target = len - k;
        while (true){
            int index = partition(nums, left, right);
            if(index==target){
                return nums[index];
            }else if(index<target){
                left = index + 1;
            }else {
                right = index - 1;
            }
        }
    }

    /**
     * 对数组nums的子区间 [left..right] 执行 partition操作，返回nums[left]排序以后应该在的位置
     * 在遍历过程中保持循环不变量的定义：
     * nums[left+1..j] < nums[left]
     * nums[j..i] >= nums[left]
     */
    private static Random random = new Random(System.currentTimeMillis());
    public int partition(int[] nums, int left, int right){
        /*
        * 在区间随机选择一个元素作为标定点(可选)
        */
        if(right > left){
            int randomIndex = left + 1 + random.nextInt(right-left);
            swap(nums, left, randomIndex);
        }
        int pivot = nums[left];
        int j = left;
        for(int i = left+1; i<=right; i++){
            if(nums[i] < pivot){
                j++; // j的初值为left,先右移，再交换，小于pivot的元素都被交换到前面。
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中,满足nums[left+1..j]<pivot,并且nums[j..i]>=pivot
        swap(nums, j, left);
        // 交换以后nums[left..j-1]<pivot,nums[j]=pivot,nums[j+1..right]>=pivot
        return j;
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}


// 减而治之（逐渐缩小问题规模）
class Main215_1{

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int target = length - k;
        int left = 0;
        int right = length - 1;
        while (true){
            int index = partition(nums, left, right);
            if(index == target){
                return nums[index];
            }else if(index < target){
                left = index + 1;
            }else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right){
        int j = left;
        int pivot = nums[left];
        for(int i = left; i<= right; i++){
            if(nums[i]<pivot){
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}


// 优先队列
class Main215_2{
    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        // 使用一个含有k个元素的最小堆,PriorityQueue底层是动态数组,为了防止数组扩容产生消耗,可以先指定数组的长度。
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // Java里没有heapify,因此我们逐个将前k个元素
        for(int i=0; i<k; i++){
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topElement = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if(nums[i] > topElement){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}