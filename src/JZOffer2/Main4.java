package JZOffer2;

/**
 * 二分查找
 */
public class Main4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (findSearch(ints, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean findSearch(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[mid] < target) {
                left = mid - 1;
            } else {
                right = mid + 1;
            }
        }
        return false;
    }
}

/**
 * Z 字形查找
 */
class Main4_1 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0){
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
