package HOT100;

public class Main34 {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target)+1;
        int end = binarySearch(nums, target+1);
        if (start <= end && nums[start] == target) {
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    int binarySearch(int[] nums, int target){
        int n = nums.length;
        int left=0, right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>=target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
}
