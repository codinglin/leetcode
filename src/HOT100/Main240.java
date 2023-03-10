package HOT100;

/**
 * 每行都进行二分搜索
 */
public class Main240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] > target) {
                break;
            }
            if(matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            int col = binarySearch(matrix[i], target);
            if(col != -1) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] matrix, int target) {
        int n = matrix.length, left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            int mid = (left + right) / 2;
            if (matrix[mid] == target) {
                return mid;
            } else if (matrix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

class Main240_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if(target > matrix[row][col]) {
                row ++;
            } else if (target < matrix[row][col]) {
                col --;
            } else {
                return true;
            }
        }
        return false;
    }
}
