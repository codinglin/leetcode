package HOT100;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int leftPoint = 0, rightPoint = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (rightPoint = 0; rightPoint < s.length(); rightPoint++) {
            if(map.containsKey(s.charAt(rightPoint))) {
                leftPoint = Math.max(leftPoint, map.get(s.charAt(rightPoint)) + 1);
            }
            map.put(s.charAt(rightPoint), rightPoint);
            maxLength = Math.max(maxLength, rightPoint - leftPoint + 1);
        }
        return maxLength;
    }
}
