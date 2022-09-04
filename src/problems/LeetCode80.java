package problems;

public class LeetCode80 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0, ans = nums[0], repeat=0;
        for(int i=0;i<n;i++){
            if(nums[i] == ans){
                repeat++;
            }else{
                repeat=1;
            }
            if(repeat>2){
                k++;
            }
            nums[i-k] = nums[i];
            ans = nums[i];
        }
        System.out.println(n-k);
        return n-k;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
    }
}
