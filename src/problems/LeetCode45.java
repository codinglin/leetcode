package problems;

public class LeetCode45 {
    public int jump(int[] nums) {
        int length= nums.length;
        int end=0,maxPosition=0,step=0;
        for(int i=0;i<length-1;i++){
            maxPosition=Math.max(maxPosition,i+nums[i]);
            if(i==end){
                end=maxPosition;
                step++;
            }
        }
        return step;
    }
}

class LeetCode45_1 {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0, begin = 0, end = 0;
        while (end < n - 1) {
            int temp = 0;
            for (int i = begin; i <= end; i++) {
                temp = Math.max(temp, i + nums[i]);
            }
            begin = end + 1;
            end = temp;
            ans ++;
        }
        return ans;
    }
}
