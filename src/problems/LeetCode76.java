package problems;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        int n = s.length();
        int m = t.length();
        int[] need = new int[128];
        for (int i = 0; i < m; i++) {
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (right < n) {
            char c = s.charAt(right);
            if(need[c] > 0) {
                count --;
            }
            need[c] --;
            if(count == 0) {
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)] ++;
                    left++;
                }
                if(right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                need[s.charAt(left)] ++;
                left++;
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
