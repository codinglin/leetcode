package HOT100;

public class Main560 {
    public static int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 0};
        int k = 0;
        subarraySum(nums, k);
    }
}
