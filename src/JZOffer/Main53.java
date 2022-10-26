package JZOffer;

public class Main53 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar){
        int i = 0, j = nums.length - 1;
        while (i<j){
            int mid = (i+j) / 2;
            if(nums[mid] <= tar){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return i;
    }
}
