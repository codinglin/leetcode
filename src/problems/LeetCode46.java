package problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        int length=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(length==0){
            return ans;
        }
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
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,length,depth+1,path,used,ans);
            path.removeLast();
            used[i]=false;
        }
    }
}

class LeetCode46_1{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int length = nums.length;
        boolean[] used = new boolean[length];
        dfs(nums, used, length, path, ret);
        return ret;
    }

    void dfs(int[] nums, boolean[] used, int length, Deque<Integer> path, List<List<Integer>> ret){
        if(path.size() == length){
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(!used[i]){
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, used, length, path, ret);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
