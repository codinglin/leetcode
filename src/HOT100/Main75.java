package HOT100;

public class Main75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        for (int i = 0; i <= right; i++) {
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right--);
            }
            if(nums[i] == 0) {
                swap(nums, i, left++);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
