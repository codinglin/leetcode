package NiukeTOP101;

import java.util.Arrays;

public class BM95 {
    public int candy (int[] arr) {
        int n = arr.length;
        if(n <= 1){
            return n;
        }
        int[] num = new int[n];
        Arrays.fill(num, 1);
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                num[i] = num[i-1] + 1;
            }
        }
        int res = num[n-1];
        for (int i = n - 2; i >= 0; i--) {
            if(arr[i] > arr[i+1] && num[i] <= num[i+1]){
                num[i] = num[i+1] + 1;
            }
            res += num[i];
        }
        return res;
    }
}
