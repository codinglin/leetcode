package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0 || n<k){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(res, path, n, k, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int n , int k, int begin){
        // 递归终止条件：path的长度等于K
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        // (int i=begin;i<n;i++)
        // 还可以进行剪枝
        for(int i=begin;i<=n-(k-path.size())+1;i++){
            path.add(i);
            dfs(res, path, n, k, i+1);
            path.remove(path.size()-1);
        }
    }
}
