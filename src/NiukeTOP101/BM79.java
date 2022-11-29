package NiukeTOP101;

import java.util.Arrays;

public class BM79 {
    public int rob (int[] nums) {
        int n=nums.length;
        //在0到n-2范围内找
        int rob1=getRob(Arrays.copyOfRange(nums,0,n-1));
        //在1到n-1范围内找
        int rob2=getRob(Arrays.copyOfRange(nums,1,n));

        return Math.max(rob1,rob2);
    }

    private int getRob(int[] nums){
        int n=nums.length;
        //边界情况处理
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        //定义dp数组
        int[] dp=new int[n];
        //初始化
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            //状态转移
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
