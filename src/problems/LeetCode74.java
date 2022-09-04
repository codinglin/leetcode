package problems;

public class LeetCode74 {
    // 方法一：两次二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if(rowIndex < 0){
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    // 先按第一列找，找到不大于目标值的行
    public int binarySearchFirstColumn(int[][] matrix, int target){
        int low = -1, high = matrix.length-1;
        while(low<high){
            int mid = (high-low+1)/2+low;
            if(matrix[mid][0] <= target){
                low = mid;
            }else {
                high = mid-1;
            }
        }
        return low;
    }

    // 再对目标行进行二分查找，看是否找到目标值
    public boolean binarySearchRow(int[] row, int target){
        int low = 0, high = row.length-1;
        while(low <= high){
            int mid = (high-low) /2 + low;
            if(row[mid] == target){
                return true;
            }else if(row[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }

    // 方法二：一次二分查找
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;
        while (low<=high){
            int mid = (high-low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if(x < target){
                low = mid + 1;
            }else if(x > target){
                high = mid -1;
            }else{
                return true;
            }
        }
        return false;
    }
}
