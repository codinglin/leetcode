package HOT100;

import java.util.HashMap;

public class Main76 {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        int n = s.length();
        int m = t.length();
        // 记录需要的字符的个数
        int[] need = new int[128];
        for (int i = 0; i < m; i++) {
            need[t.charAt(i)] ++;
        }
        // left 是当前左边界，right 是当前右边界，size 记录窗口大小，count 是需求的字符个数，start 是当前覆盖串开始的 index
        int left = 0, right = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        // 遍历所有字符
        while (right < n) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                count --;
            }
            need[c] --;
            if(count == 0) {
                // 如果左边界这个元素对应的值在 need[] 数组中小于 0，说明他是一个多余元素，不包含在 t 内
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)] ++;
                    left++;
                }
                // 如果当前的这个窗口值比之前维护的窗口值更小，需要进行更新
                if(right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                need[s.charAt(left)] ++;
                left ++;
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
