package problems;

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int k = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i] == val){
                continue;
            }
            nums[k++] = nums[i];
        }
        return k;
    }
}
