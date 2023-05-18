package tree;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String a = sc.next();
            String b = sc.next();
            if(a.length() == 1) {
                System.out.println(a + b);
            }else {
                System.out.println(maxInsert(a, b));
            }
        }
    }

    private static String maxInsert(String a, String b){
        int position = 0;
        for (position = 0; position < a.length(); position++) {
            if(a.charAt(position) - '0' < Integer.parseInt(b)) {
                break;
            }
        }
        StringBuffer sb = new StringBuffer(a);
        sb.insert(position, b);
        return sb.toString();
    }
}
