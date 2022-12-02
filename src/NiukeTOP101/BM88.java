package NiukeTOP101;

public class BM88 {
    public boolean judge (String str) {
        int n = str.length();
        int mid = n / 2, left, right;
        left = mid - 1;
        if(n % 2 == 1){
            right = mid + 1;
        }else{
            right = mid;
        }
        while (left >= 0 && right < n){
            if(str.charAt(left--) != str.charAt(right++)){
                return false;
            }
        }
        return true;
    }
}
