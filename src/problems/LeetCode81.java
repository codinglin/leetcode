package problems;

public class LeetCode81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high=n-1;
        while (low<=high){
            int mid = low + (high - low) /2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[low]==nums[mid]){
                low++;
                continue;
            }
            // 前半段有序
            if(nums[low] < nums[mid]){
                // target在前段部分
                if(nums[mid]>target && nums[low]<=target){
                    high = mid - 1;
                }else {
                    low = mid+1;
                }
            }else{
                //后半段有序
                //target在后段部分
                if(nums[mid]<target && nums[high]>=target){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
