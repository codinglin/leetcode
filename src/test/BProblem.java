package test;

import java.util.Scanner;

public class BProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int maxCount = 0;
        if(n > m){
            maxCount = n;
        }else{
            maxCount = m;
        }
        int[] nArr = new int[maxCount];
        int[] mArr = new int[maxCount];
        for (int i = n - 1; i >= 0; i--) {
            nArr[i] = sc.nextInt();
        }
        for (int i = m - 1; i >= 0; i--) {
            mArr[i] = sc.nextInt();
        }
        int[] result = new int[maxCount + 1];
        int carry = 0;
        for (int i = 0; i < maxCount; i++) {
            int sum = (nArr[i] + mArr[i] + carry) % (i+2);
            carry = (nArr[i] + mArr[i] + carry) / (i+2);
            result[i] = sum;
        }
        if(carry != 0){
            result[maxCount] = carry;
        }
        boolean flag = false;
        int countNum = 0;
        for (int i = 0; i <= maxCount; i++) {
            if(result[maxCount] == 0){
                countNum++;
            }
        }
        if(countNum == maxCount + 1){

        }else{

        }
        for (int i = maxCount; i >=0 ; i--) {
            if(result[i] != 0){
                flag = true;
            }
            if(flag==false && result[i] == 0){
                continue;
            }
            if(i != 0){
                System.out.print(result[i] + " ");
            }else{
                System.out.print(result[i]);
            }
        }
        System.out.println();
    }
}
