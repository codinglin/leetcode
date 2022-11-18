package NiukeTOP101;

public class MergeSort {
    private void mergeSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j<= right){
            if(arr[i] >= arr[j]){
                temp[k++] = arr[j++];
            }else{
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = left; i <= right; ++i, ++k) {
            arr[i] = temp[k];
        }
    }

    private void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }
}
