package problems;

import java.util.Arrays;

public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        int j = 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            while (j < s.length) {
                if(s[j] >= g[i]) {
                    count++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return count;
    }
}
