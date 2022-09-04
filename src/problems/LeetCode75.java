package problems;

public class LeetCode75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int newNums[] =new int[n];
        int red = 0;
        int blue = n-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                newNums[red++]=0;
            }
            if(nums[i]==2){
                newNums[blue--]=2;
            }
        }
        for(int i=red;i<blue;i++){
            newNums[i]=1;
        }
        for(int i=0;i<n;i++){
            nums[i]=newNums[i];
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int p0 = 0,p2 = n-1;
        for(int i=0; i <= p2; ++i){
            while(i <= p2 && nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if(nums[i] ==0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
