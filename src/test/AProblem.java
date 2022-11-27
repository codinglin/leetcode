package test;

import java.util.Scanner;

public class AProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        int sgnB = 1;
        if(b > 0){
            sgnB = 1;
        }
        if(b < 0){
            sgnB = -1;
        }
        long absA = Math.abs(a);
        System.out.println(sgnB * absA);
    }
}
