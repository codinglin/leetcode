package HOT100;

import java.util.Arrays;

public class Main581 {
    /**
     * 一次遍历
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int endIndex = -1, maxValue = nums[0];
        for (int i = 0; i < length; i++) {
            if(nums[i] < maxValue) {
                endIndex = i;
            } else {
                maxValue = nums[i];
            }
        }
        int startIndex = -1, minValue = nums[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            if(nums[i] > minValue) {
                startIndex = i;
            } else {
                minValue = nums[i];
            }
        }
        return endIndex == -1 ? 0 : endIndex - startIndex + 1;
    }

    /**
     * 一次遍历优化
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE, right = -1;
        int minValue = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if(maxValue > nums[i]) {
                right = i;
            } else {
                maxValue = nums[i];
            }
            if(minValue < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minValue = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        if(isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 2};
        findUnsortedSubarray(nums);
    }
}
