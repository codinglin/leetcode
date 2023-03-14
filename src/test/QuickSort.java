package test;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {6,72,113,11,23};
        quickSort(array, 0, array.length -1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            int x = array[low];
            int i = low;
            int j = high;
            while (i < j) {
                while(i < j && array[j] > x) {
                    j--;
                }
                if(i < j) {
                    array[i++] = array[j];
                }
                while (i < j && array[i] < x) {
                    i++;
                }
                if(i < j) {
                    array[j--] = array[i];
                }
            }
            array[i] = x;
            quickSort(array, low, i);
            quickSort(array, i + 1, high);
        }
    }
}

class QuickSort_1 {

    public static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            // 获取划分子数组的位置
            int position = partition(array, low, high);
            quickSort(array, low, position);
            quickSort(array, position + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放右边，比元素小的放左边
        for(int i = low; i < high; i++) {
            if(array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
        }
        // 将中心元素和指针指向的元素交换位置
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }
}