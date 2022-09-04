package binarySearch;

public class Test {
    static int k = 500;
    static int[] C = new int[k+5];

    static void CountingSort(int[] A){
        int n = A.length;
        int[] B = new int[A.length];
        for(int h=0;h<k+1;h++){
            C[h]=0;
        }
        for(int i=0;i<n;i++){
            C[A[i]+1]=C[A[i]+1]+1;
        }
        for(int i=1;i<k+1;i++){
            C[i] = C[i-1] + C[i];
        }
        for(int i=0;i<n;i++){
            B[C[A[i]]] = A[i];
            C[A[i]] = C[A[i]]-1;
        }
        for(int i=0;i<n;i++){
            System.out.println(B[i]);
        }
    }

    public static void main(String[] args) {
        int[] A = {10, 121, 234, 499, 18};
        CountingSort(A);
    }
}
