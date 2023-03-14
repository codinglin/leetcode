package problems;

import java.util.Random;

/**
 * 基于快速排序的选择方法
 */
public class LeetCode215 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if(q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }
    }

    public int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int pointer = l;
        for (int i = l; i < r; i++) {
            if(nums[i] <= pivot) {
                swap(nums, i, pointer++);
            }
        }
        swap(nums, pointer, r);
        return pointer;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Code215_1{
    Random random = new Random();
    public int findKthLargest(int[] nums, int k){
        return quickSort(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int k, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        int pivot = nums[i];
        swap(nums, i, right);
        int pointer = left;
        for (int j = left; j < right; j++) {
            if(nums[j] <= pivot) {
                swap(nums, j, pointer++);
            }
        }
        swap(nums, right, pointer);
        if(pointer == k) {
            return nums[pointer];
        } else {
            return pointer < k ? quickSort(nums, k, pointer + 1, right) : quickSort(nums, k, left, pointer - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * 基于堆排序的选择方法
 */
class LeetCode215_2 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            -- heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
