package problems;

import java.util.Arrays;

public class LeetCode475 {
    /**
     * 方法一：排序 + 二分查找
     * 为了使供暖器可以覆盖所有房屋且供暖器的加热半径最小，对于每个房屋，应该选择离该房屋最近的供暖器覆盖该房屋，
     * 最近的供暖器和房屋的距离即为该房屋需要的供暖器的最小加热半径。
     * 所有房屋需要的供暖器的最小加热半径中的最大值即为可以覆盖所有房屋的最小加热半径。
     * 为了得到距离每个房屋最近的供暖器，可以将供暖器数组 heaters 排序，然后通过二分查找得到距离最近的供暖器。
     * 具体而言，对于每个房屋 house，需要在有序数组 heaters 中找到最大的下标 i，使得 heaters[i] ≤ house，
     * 特别地，当 heaters[0] > house 时，i = -1。在得到下标 i 之后，令 j = i + 1，则 j 是满足 heaters[j] > house 的最小下标。
     * 特别地，当 heaters[n−1] ≤ house 时，j = n，其中 n 是数组 heaters 的长度。
     * 得到下标 i 和 j 之后，离房屋 house 最近的供暖器为 heaters[i] 或 heaters[j]，
     * 分别计算这两个供暖器和房屋 house 的距离，其中的最小值即为该房屋需要的供暖器的最小加热半径。
     * 对于 i = -1 或 j = n 的下标越界情况，只要将对应的距离设为 +∞ 即可。
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[left] > target) {
            return -1;
        }
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * 方法二：排序 + 双指针
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
