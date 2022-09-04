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
