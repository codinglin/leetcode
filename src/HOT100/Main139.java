package HOT100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main139 {
    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        if(length==0){
            return true;
        }
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i=0; i<wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        for(int i=1; i<=s.length(); i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&check(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[length];
    }

    private boolean check(String str){
        if(set.contains(str)){
            return true;
        }
        return false;
    }
}

/*
  0-1背包问题
    可定义状态dp: dp[i][j]表示将前i件物品装进限重为j的背包可以获得的最大价值,0<=i<=N, 0<=j<=W
    当i>0时dp[i][j]有两种情况:
        1.不装入第i件物品,即dp[i-1][j].
        2.装入第i件物品(前提是能装下),即dp[i-1][j-w[i]] + v[i].
    即状态转移方程为
        dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]) // j>=w[i]

  完全背包问题:
     完全背包与0-1背包不同就是每种物品可以有无限多个:一共有N种物品,每种物品有无限多个,第i(i从1开始)种物品
     的重量为w[i],价值为v[i].

  背包问题具备的特征：
     是否可以根据一个target(直接给出或间接求出),target可以是数字也可以是字符串，再给定一个数组arr
     问：能否使用arr中的元素做各种排列组合得到target.
*/
class Main139_1{
    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        if(length==0){
            return true;
        }
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i=0; i<wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        for(int i=1; i<=s.length(); i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&check(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[length];
    }

    private boolean check(String str){
        if(set.contains(str)){
            return true;
        }
        return false;
    }
}
