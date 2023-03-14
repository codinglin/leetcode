package JZOfferTuJi;

public class Main9 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0, ret=0, total=1;
        for(int right = 0; right < nums.length; right++){
            total *= nums[right];
            while (left <= right && total >= k){
                total /= nums[left++];
            }
            if(left <= right){
                ret += right - left + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        numSubarrayProductLessThanK(nums, 100);
    }
}
