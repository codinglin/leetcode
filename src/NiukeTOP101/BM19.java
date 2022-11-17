package NiukeTOP101;

public class BM19 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1, mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] > nums[mid+1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
