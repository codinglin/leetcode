package NiukeTOP101;

public class BM17 {
    public int search (int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1, mid;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
