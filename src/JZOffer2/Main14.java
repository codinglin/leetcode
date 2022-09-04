package JZOffer2;

import java.util.Arrays;

public class Main14 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }

        int[] s1_array = new int[32];
        int[] s2_array = new int[32];

        for(char c: s1.toCharArray()){
            s1_array[c-'a']++;
        }
        for(char c: s2.substring(0, n).toCharArray()){
            s2_array[c-'a']++;
        }

        if(Arrays.equals(s1_array, s2_array)){
            return true;
        }

        for(int i = n; i < m; i++){
            s2_array[s2.charAt(i)-'a']++;
            s2_array[s2.charAt(i-n)-'a']--;
            if(Arrays.equals(s1_array, s2_array)){
                return true;
            }
        }
        return false;
    }
}


// 用一个变量 diff 来记录cnt1与cnt2的不同值的个数，这样判断cnt1和cnt2是否相等就转换成了判断diff是否为0
class Main14_1{
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for(int c: cnt){
            if(c!=0){
                ++diff;
            }
        }
        if(diff==0){
            return true;
        }
        for(int i=n; i<m; ++i){
            int x = s2.charAt(i) - 'a';
            int y = s2.charAt(i - n) - 'a';
            if(x == y){
                continue;
            }
            if(cnt[x] == 0){
                ++diff;
            }
            ++cnt[x];
            if(cnt[x] == 0){
                --diff;
            }
            if(cnt[y] == 0){
                ++diff;
            }
            --cnt[y];
            if(cnt[y] == 0){
                --diff;
            }
            if(diff == 0){
                return true;
            }
        }
        return false;
    }
}
