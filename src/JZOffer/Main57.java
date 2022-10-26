package JZOffer;

public class Main57 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if(n==2){
            if(nums[0] + nums[1] == target){
                return new int[]{nums[0], nums[1]};
            }else{
                return new int[]{};
            }
        }
        for(int i = 0; i < n; i++){
            if(i+1 <= n-1 &&binarySearch(nums,i+1, n-1, target - nums[i])){
                return new int[]{nums[i], target - nums[i]};
            }
        }
        return new int[]{};
    }

    boolean binarySearch(int[] nums, int left, int right, int num){
        while (left <= right){
            int mid = (left+right) / 2;
            if(nums[mid] == num){
                return true;
            }
            else if(nums[mid] > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
