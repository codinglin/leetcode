package JZOfferTuJi;

import java.util.*;

public class Main7 {
    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            // 去重
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int anchor = nums[i];
            search(nums, i, i+1, n-1, -anchor);
        }
        return new ArrayList<>(ans);
    }

    private void search(int[] nums, int anchor ,int left, int right, int target){
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                ans.add(Arrays.asList(nums[anchor], nums[left], nums[right]));
                // 去重
                while (left < right && nums[left] == nums[++left]);
                while (left < right && nums[right] == nums[--right]);
            } else if(sum < target){
                left++;
            } else{
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        Main7 main = new Main7();
        main.threeSum(nums);
    }
}
