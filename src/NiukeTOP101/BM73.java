package NiukeTOP101;

/**
 * 贪心算法，中心扩展法
 */
public class BM73 {
    public int getLongestPalindrome (String A) {
        int n = A.length();
        int maxLen = 1;
        // 以每个点为中心
        for (int i = 0; i < n; i++) {
            // 分奇数长度和偶数长度向两边扩展
            maxLen = Math.max(maxLen, Math.max(fun(A, i, i), fun(A, i, i + 1)));
        }
        return maxLen;
    }

    private int fun(String s, int begin, int end){
        while (begin >=0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        return end - begin - 1;
    }
}

/**
 * manacher算法（扩展思路）
 * 动态规划
 * step 1：我们用maxpos表示目前已知的最长回文子串的最右一位的后一位，用index表示当前的最长回文子串的中心点。
 * step 2：对于给定的 i 我们找一个和它关于index对称的 j ，也就是index−j==i−index，换言之就是j==2∗index−i。
 * step 3：i 和 j 的最长回文子串在index的回文串范围内的部分应该是一模一样的，但是在外面的部分就无法保证了，当然，最好的情况是i和j的回文子串范围都很小，这样就保证了它们的回文子串一定一模一样，对于超出的部分我们也没有办法, 只能手动使用中心扩展。
 * step 4：最后答案计算的时候需要考虑使用预处理，长度被加了一倍，于是结果是 max(mp[i]-1)。
 */
class BM73_1{
    //manacher算法
    public void manacher(String s, int n, int[] mp){
        String ms = "";
        ms += "$#";
        //预处理
        for(int i = 0; i < n; i++){
            //使之都变成奇数回文子串
            ms += s.charAt(i);
            ms += '#';
        }
        //目前已知的最长回文子串的最右一位的后一位
        int maxpos = 0;
        //当前的最长回文子串的中心点
        int index = 0;
        for(int i = 0; i < ms.length(); i++){
            mp[i] = maxpos > i ? Math.min(mp[2 * index - i], maxpos - i) : 1;
            while(i - mp[i] > 0 && i + mp[i] < ms.length() && ms.charAt(i + mp[i]) == ms.charAt(i - mp[i]))
                //两边扫
                mp[i]++;
            //更新位置
            if(i + mp[i] > maxpos){
                maxpos = i + mp[i];
                index = i;
            }
        }
    }
    public int getLongestPalindrome (String A) {
        int n = A.length();
        //记录回文子串长度
        int[] mp = new int[2 * n + 2];
        manacher(A, n, mp);
        int maxlen = 0;
        //遍历数组
        for(int i = 0; i < 2 * n + 2; i++)
            //找到最大的长度
            maxlen = Math.max(maxlen, mp[i] - 1);
        return maxlen;
    }
}
