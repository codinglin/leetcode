package test;

public class MergeSort {
    public void mergeSort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if(left < right) {
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            mergeTwoArray(array, left, mid, right);
        }
    }

    private void mergeTwoArray(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left; // 左指针
        int j = mid + 1; // 右指针
        int count = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= right) {
            if(array[i] <= array[j]) {
                temp[count++] = array[i++];
            } else {
                temp[count++] = array[j++];
            }
        }
        if(i <= mid) {
            temp[count++] = array[i++];
        }
        if(j <= right) {
            temp[count++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }

}
