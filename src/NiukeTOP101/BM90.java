package NiukeTOP101;

public class BM90 {
    public String minWindow (String S, String T) {
        int cnt = S.length() + 1;
        int[] hash = new int[128];
        for (int i = 0; i < T.length(); i++) {
            hash[T.charAt(i)]--;
        }
        int slow = 0, fast = 0;
        int left = -1, right = -1;
        for (fast = 0; fast < S.length(); fast++) {
            hash[S.charAt(fast)]++;
            while (check(hash)){
                //取最优解
                if(cnt > fast - slow + 1){
                    cnt = fast - slow + 1;
                    left = slow;
                    right = fast;
                }
                hash[S.charAt(slow)]--;
                slow ++;
            }
        }
        if(left == -1){
            return "";
        }
        return S.substring(left, right + 1);
    }

    private boolean check(int[] hash) {
        for (int j : hash) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }
}
