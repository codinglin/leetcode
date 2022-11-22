package NiukeTOP101;

public class BM47 {
    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, a.length - 1, K);
    }

    private int quickSort(int[] arr, int left, int right, int k) {
        int p = partition(arr, left, right);
        if(p == arr.length - k){
            return arr[p];
        }
        else if(p < arr.length - k){
            return quickSort(arr, p + 1, right, k);
        }
        else{
            return quickSort(arr, left, p - 1, k);
        }
    }

    private int partition(int[] arr, int left, int right){
        int key = arr[left];
        while(left < right){
            while (left < right && arr[right] >= key){
                right --;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key){
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[right] = key;
        return left;
    }
}

class QuickSort{
    public void quickSort(int[] arr, int left, int right){
        int anchor = partition(arr, left, right);
        quickSort(arr, left, anchor - 1);
        quickSort(arr, anchor + 1, right);
    }

    private int partition(int[] arr, int left, int right){
        int point = arr[left];
        while (left < right){
            while (left < right && arr[right] >= point){
                right --;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= point){
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[right] = point;
        return left;
    }
}
