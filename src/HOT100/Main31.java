package HOT100;

/**
 * 思路：
 * 1. 先倒序遍历数组, 找到第一个 nums[i] (前一个数比后一个数小的位置) (即nums[i] < nums[i+1]);
 * 2. 这个时候我们不能直接把后一个数nums[i+1] 跟前一个数nums[i]交换就完事了; 还应该从nums[i+1]-->数组末尾这一段的数据中 找出最优的那个值( 如何最优? 即比nums[i]稍微大那么一丢丢的数, 也就是 nums[i+1]-->数组末尾中, 比nums[i]大的数中最小的那个值)
 * 3. 找到之后, 跟num[i]交换, 这还不算是下一个排列, num[i]后面的数值还不够小, 所以还应当进升序排列
 * 例子: nums = [1,2,7,4,3,1],
 *      第一步: 倒序遍历数组, 找出第一组: 前一个数比后一个数小的两个数, 即[2, 7]
 *      2所处的这个位置就是需要找出比它稍微大的数的位置;
 *      我们从[7,4,3,1]中找出比2大的数中的最小值, 也就是3, 找到后跟2交换即可;; 当然了, 如果没找到的话, 直接跳到第5步, 直接升序排列输出.
 *      目前nums=[1,3,7,4,2,1], 不用我说你们也看出来还不算下一个排列
 *      对3后面的数, 升序排列, 即最终结果: nums = [1,3,1,2,4,7]
 */
public class Main31 {

    public void nextPermutation(int[] nums) {
        //1. 1,2,3 ==> 1,3,2
        //1. 倒序遍历, 找到第一个数, 这个数比后面的数小;
        //2. 继续倒序遍历, 找到一个比上面的数大的数;
        //3. 交换
        //4. 把1中的这个数后面的数全部递增排列, 因为在1后面的数时递减排列的, 所以首尾交换即可获得升序排列
        int len = nums.length;
        int i = len - 2; //i = len - 2 是为了防止下面nums[i + 1]越界!

        //1. 倒序遍历, 找到第一个数, 这个数比后面的数小;
        while(i >= 0){
            if(nums[i] < nums[i + 1])break;
            --i;
        }

        //2. 继续倒序遍历, 找到一个上面的数大的数
        if(i >= 0){
            int j = len - 1;
            while(j >= 0){
                if(nums[j] > nums[i])break;
                --j;
            }
            //3. 交换i和j
            swap(nums, i, j); //交换i和j的位置
        }

        //4. 将 i后面的数升序排列, 只需要对撞双指针交换即可(因为i后面的数时降序的)
        reverse(nums, i + 1, len - 1);
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {

    }
}
