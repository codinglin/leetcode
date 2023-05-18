package problems;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode55 {
    public static boolean canJump(int[] nums) {
        int n = nums.length, x, end=0, maxPosition=0, i, j, step;
        boolean flag = false, flag2 = false;
        if(n==0 || (n==1 && nums[0]>0)){
            return true;
        }
        for(i=0; i<n; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(maxPosition>=n-1){
                flag = true;
                break;
            }
            if(i==end) {
                if (nums[maxPosition] != 0) {
                    end = maxPosition;
                } else {
                    step = 0;
                    flag2 = false;
                    for (j = maxPosition - 1; j > end; j--) {
                        step++;
                        if (nums[j] != 0 && nums[j] > step) {
                            end = j + nums[j];
                            flag2 = true;
                            break;
                        }
                    }
                    if (j <= end && flag2 == false) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int maxPosition=0;
        for(int i=0; i< n; i++){
            if(i<=maxPosition){
                maxPosition = Math.max(maxPosition, i+nums[i]);
                if(maxPosition>=n-1){
                    return true;
                }
            }
        }
        return false;
    }

    // 本质上是隐式(implict)BFS，我们维护一个最远能走到的距离rightmost，在维护该变量的过程中发现它的距离大于等于nums.length-1，那就能够到达末尾。如果看不太懂，放一个显式(explicit)BFS，能通过，只不过非常慢。
    public boolean canJumpBFS(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        q.offer(0);
        while(!q.isEmpty()) {
            for(int size=q.size();size>0;size--) {
                // idx is current position
                int idx = q.remove();
                // if this condition is true, we can find an answer
                if(idx >= nums.length - 1) return true;
                // i is the next rightmost position we can reach
                for(int i=idx + 1;i < nums.length &&
                        i<=idx + nums[idx];i++) {
                    if(visited[i]) continue;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return false;
    }

    // dp表示前i个元素所能到达的最远位置
    public static boolean canJumpDP(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1){
            return true;
        }
        if (nums[0] == 0)
            return false;
        if(n==1){
            if(nums[0]==0){
                return false;
            }else {
                return true;
            }
        }
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            if(dp[i-1]>=n-1){
                return true;
            }
            if(i <= dp[i-1]) {
                dp[i] = Math.max(dp[i - 1], i + nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,2,0,2,0,2,0,0,2,0};
        canJumpDP(a);
    }
}

class LeetCode55_1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if(i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}
