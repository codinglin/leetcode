package HOT100;

import java.util.ArrayList;
import java.util.List;

/*
*  具体来说，遍历nums，每遇到一个数x,就让nums[x-1]增加n。
*  由于nums中所有数均在[1,n]中,增加以后,这些数必然大于n。
*  若nums[i]未大于n,就说明没有遇到过数i+1。
*/
public class Main448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int num: nums){
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[i]<=n){
                ret.add(i+1);
            }
        }
        return ret;
    }
}

/*
*  这题用鸽笼原理实现，1~n的位置表示1~n个笼子,如果出现过,相应的'鸽笼'就会被占掉，将数字置于负数表示被占掉了。
*  最后再遍历一遍.如果'鸽笼'为正数就是没出现的数字。
*/
class Main448_1{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num: nums){
            nums[Math.abs(num)-1] = - Math.abs(nums[Math.abs(num)-1]);
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                ret.add(i+1);
            }
        }
        return ret;
    }
}
