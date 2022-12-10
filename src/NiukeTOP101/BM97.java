package NiukeTOP101;

public class BM97 {
    public int[] solve (int n, int m, int[] a) {
        m = m % n;
        reverse(0, n-m, a);
        reverse(n-m, n, a);
        reverse(0, n, a);
        return a;
    }

    void reverse(int start, int end, int[] arr){
        for (int i = start; i < start + (end - start) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[start+end-i-1];
            arr[start+end-i-1] = temp;
        }
    }
}
