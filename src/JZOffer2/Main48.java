package JZOffer2;

import java.util.HashMap;
import java.util.Map;

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

/**
 * 动态规划
 *  状态定义：dp[j]代表以字符s[j]为结尾的"最长不重复子字符串"的长度。
 *  转移方程：固定右边界j，设字符s[j]左边距离最近的相同字符为s[i]，即s[i] = s[j]
 *      1.当i<0,即s[j]左边无相同字符，则dp[j] = dp[j-1] + 1
 *      2.当dp[j-1] < j-i，说明字符s[i]在子字符串dp[j-1]区间之外，则dp[j] = dp[j-1] + 1;
 *      3.当dp[j-1] >= j-i,说明字符s[i]在子字符串dp[j-1]区间之中，则dp[j]的左边界由s[i]决定，即dp[j]=j-i;
 */
class Main48_1{
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j<s.length(); j++){
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j-i? tmp+1:j-i;
            res = Math.max(res,tmp);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while(i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}

/**
 * 双指针
 */
class Main48_2{
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
