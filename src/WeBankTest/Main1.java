package WeBankTest;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int L = sc.nextInt();
            int R = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            System.out.println(count(L, R, X, Y));
        }
    }

    private static int count(int L, int R, int X, int Y) {
        int count = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if(Integer.bitCount(i) >= L && Integer.bitCount(i) <= R && (i & X) == X && (i | Y) == Y){
                count ++;
//                System.out.print(i + " ");
            }
        }
//        System.out.println("----------");
        return count;
    }

//    private int beiShu(int )
}
