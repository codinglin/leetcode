package problems;

public class LeetCode303 {
    int[] sums;
    public LeetCode303(int[] nums) {
        sums = new int[nums.length+1];
        sums[0] = 0;
        for(int i=0; i< nums.length; i++){
            sums[i+1]=nums[i]+sums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1]-sums[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        LeetCode303 a = new LeetCode303(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(a.sums[i]);
        }
    }
}
