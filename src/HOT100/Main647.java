package HOT100;

public class Main647 {

    /*
    * 中心扩展
    * 长度为n的字符串会生成2n-1组会问中心[l_i,r_i]，其中
    * */
    public int countSubstrings(String s) {
        int n = s.length();
        int length = 2 * n - 1;
        int ans = 0;
        for(int i=0; i<length; i++){
            int left = i/2;
            int right = i/2 + i%2;
            while (left>0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
}
