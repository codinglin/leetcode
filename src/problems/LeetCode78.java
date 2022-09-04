package problems;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        dfs(res, path, nums, n, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int n, int start){
        for(int i=start;i<=n;i++){
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(res, path, nums, n, i+1);
            path.remove(path.size()-1);
        }
    }
}


// 迭代法
class Solution1{
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums){
        int n = nums.length;
        for(int mask = 0; mask<(1<<n); ++mask){
            t.clear();
            for(int i=0; i<n; ++i){
//                System.out.println(mask+"---"+(1<<i)+"---"+(mask & (1<<i)));
                if((mask & (1<<i))!=0){
//                    System.err.print((1<<i)+" ");
//                    System.out.print(nums[i]+" ");
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 s=new Solution1();
        int nums[]={1, 2, 3};
        s.subsets(nums);
    }
}


// 递归法
class Solution2{
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums){
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums){
        if(cur == nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur+1, nums);
        t.remove(t.size()-1);
        dfs(cur+1, nums);
    }
}
