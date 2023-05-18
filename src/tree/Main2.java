package tree;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            // 使用二分搜索
            int left = 1, right = i;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if(dp[mid] >= a[i]){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            dp[right] = a[i];
        }
        int count = n;
        while (count -- > 0) {
            if(dp[count] != Integer.MAX_VALUE) {
                System.out.println(n - count);
                break;
            }
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            a[i] = sc.nextInt();
            for (int j = 1; j < i; j++) {
                if(a[j] >= a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(n - res);
    }
}
