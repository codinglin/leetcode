package JZOffer;

public class Main48 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        char[] c = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int max = 0;
        for (int i = 0; i < c.length; i++) {
            int pos = result.lastIndexOf(String.valueOf(c[i]));
            if(pos == -1){
                result.append(c[i]);
                if(result.length()>max){
                    max = result.length();
                }
            }else {
                result = new StringBuilder(result.substring(pos+1));
                result.append(c[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("aabaab!bb");
    }
}
