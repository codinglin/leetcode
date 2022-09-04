package HOT100;

import java.util.ArrayList;
import java.util.Arrays;

public class Main287 {
    public int findDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]==nums[i]){
                return nums[i];
            }
        }
        return 0;
    }
}

class Main287_1{

}
