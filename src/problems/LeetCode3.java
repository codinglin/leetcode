package problems;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            map.put(c, end + 1);
            ans = Math.max(ans, end - start + 1);
            end ++;
        }
        return ans;
    }
}
