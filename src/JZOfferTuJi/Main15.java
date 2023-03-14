package JZOfferTuJi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main15 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        if (n < m) {
            return ans;
        }

        int[] s_array = new int[32];
        int[] p_array = new int[32];

        for(char c: s.substring(0, m).toCharArray()){
            s_array[c-'a']++;
        }
        for(char c: p.toCharArray()){
            p_array[c-'a']++;
        }

        if(Arrays.equals(s_array, p_array)){
            ans.add(0);
        }

        for(int i = m; i < n; i++){
            s_array[s.charAt(i)-'a']++;
            p_array[s.charAt(i-n)-'a']--;
            if(Arrays.equals(s_array, p_array)){
                ans.add(i);
            }
        }
        return ans;
    }
}
