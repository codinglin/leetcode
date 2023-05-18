package problems;

public class LeetCode53 {
    public static int maxSubArray(int[] nums) {
        int sum=0;
        int ans=nums[0];
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            if(sum>0){
                if(sum>ans){
                    ans=sum;
                }
            }else {
                sum=0;
            }
        }
        int min=-999999;
        if(ans<0){
            for(int i=0;i<nums.length;i++){
                if(nums[i]>min){
                    min=nums[i];
                }
            }
            ans=min;
        }
        return ans;
    }

    public static int maxSubArraySolution(int[] nums) {
        int length= nums.length;
        if(length==0){
            return 0;
        }
        int ans=nums[0],temp=nums[0];
        for(int i=1;i<length;i++){
            if(temp>0){
                temp=temp+nums[i];
            }else {
                temp=nums[i];
            }
            ans = Math.max(ans,temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}

class LeetCode53_1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
