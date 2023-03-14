package JZOffer2;

public class Main42 {
    /**
     * 前缀和思想
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int min = 0;
        int ans = Integer.MIN_VALUE;
        int num = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            num += nums[i];
            // ans = Math.max（ans, 当前前缀和-最小前缀和）
            ans = Math.max(ans , num - min);
            // 每次取最小前缀和
            if(num<min){
                min = num;
            }
        }
        return ans;
    }
}

/**
 * 动态规划
 * 状态定义：dp[i]表示以nums[i]结尾的连续子数组的最大和
 */
class Main42_1{
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if(dp[i-1]>=0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            if(dp[i] > max){
                max = dp[i];
            }

        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int former = 0;//用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
        int cur = nums[0];//用于记录dp[i]的值
        for(int num:nums){
            cur = num;
            if(former>0) cur +=former;
            if(cur>max) max = cur;
            former=cur;
        }
        return max;
    }
}

/**
 * 分治
 */
class Main_2{
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum; // 表示 [l,r] 内以 l 为左端点的最大字段和
            this.rSum = rSum; // 表示 [l,r] 内以 r 为右端点的最大字段和
            this.mSum = mSum; // 表示 [l,r] 内的最大字段和
            this.iSum = iSum; // 表示 [l,r] 的区间和
        }
    }
    
    public int maxSubArray(int[] nums){
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] a, int l, int r) {
        if(l == r){
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    private Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
