package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if(sLen < pLen){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i=0; i<pLen; i++){
            ++sCount[s.charAt(i)-'a'];
            ++pCount[p.charAt(i)-'a'];
        }
        if(Arrays.equals(sCount, pCount)){
            ans.add(0);
        }
        for(int i=0; i < sLen - pLen; i++){
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if(Arrays.equals(sCount, pCount)){
                ans.add(i + 1);
            }
        }
        return ans;
    }
}


class Main438_1{
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if(sLen < pLen){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];
        for(int i=0; i < pLen; i++){
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }
        int differ = 0;
        for(int j=0; j<26; j++){
            if(count[j]!=0){
                differ++;
            }
        }
        if(differ == 0){
            ans.add(0);
        }
        for(int i=0; i<sLen-pLen; i++){
            if(count[s.charAt(i) - 'a'] == 1){
                --differ;
            }else if(count[s.charAt(i) - 'a'] == 0){
                ++differ;
            }
            --count[s.charAt(i) - 'a'];
            if(count[s.charAt(i+pLen) - 'a'] == -1){
                --differ;
            }else if(count[s.charAt(i+pLen)-'a'] == 0){
                ++differ;
            }
            ++count[s.charAt(i+pLen) - 'a'];
            if(differ == 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
