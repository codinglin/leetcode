package problems;

public class LeetCode1545 {
    public char findKthBit(int n, int k) {
        String str = "0";
        // String str = "";
        for (int i = 2; i <= n; i++) {
            str = str + "1" + reverse(invert(str));
        }
        return str.charAt(k-1);
    }

    private String invert(String str){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0'){
                builder.append('1');
            }else{
                builder.append('0');
            }
        }
        return builder.toString();
    }

    private String reverse(String str){
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode1545 leetCode1545 = new LeetCode1545();
        leetCode1545.findKthBit(4, 11);
    }
}

class LeetCode1545_1{
    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            k = mid * 2 - k;
            return invert(findKthBit(n - 1, k));
        }
    }

    public char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }
}
