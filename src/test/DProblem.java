package test;

import java.util.Arrays;
import java.util.Scanner;

public class DProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        while (m-- > 0){
            int countMax = 0;
            int countMin = 0;
            int max = arr[n-1];
            int min = arr[0];
            for (int i = 0; i < n; i++) {

            }
        }
    }
}
