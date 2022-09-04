package problems;

import java.util.*;

public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(length==0){
            return ans;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        boolean used[]=new boolean[length];
        dfs(nums,length,0,path,used,ans);
        return ans;
    }

    // 深搜
    private void dfs(int[] nums, int length, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> ans) {
        if(depth==length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<length;i++){
            if(used[i]){
                continue;
            }
            // 剪枝条件：i>0是为了保证nums[i-1]有意义
            // 写used[i-1]==false是因为nums[i-1]在深度优先遍历的过程中刚刚被撤销选择
            if(i>0&&nums[i]==nums[i-1]&& !used[i - 1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,length,depth+1,path,used,ans);
            path.removeLast();
            used[i]=false;
        }
    }
}
