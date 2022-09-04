package HOT100;

public class Main238 {
    // 前缀（prefix）、后缀（suffix）
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
//        int[] suffix = new int[n];
        prefix[0] = 1;
//        suffix[n-1] = 1;
        int sum=1;
        for(int i=1; i<n; i++){
            sum*=nums[i-1];
            prefix[i]=sum;
        }
        sum=1;
        for(int i=n-2; i>=0; i--){
            sum*=nums[i+1];
            prefix[i]=sum * prefix[i];
        }
//        for(int i=0; i<n; i++){
//            prefix[i] = prefix[i] * suffix[i];
//        }
        return prefix;
    }

}
