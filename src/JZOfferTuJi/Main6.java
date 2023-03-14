package JZOfferTuJi;

public class Main6 {
    // 二分查找
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0; i<n-1; i++){
            int x = numbers[i];
            int index = binarySearch(numbers, i+1, n-1, target - x);
            if(index!=-1){
                return new int[]{i, index};
            }
        }
        return new int[0];
    }

    private int binarySearch(int[] numbers, int left, int right, int target){
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(numbers[mid] == target){
                return mid;
            }else if(numbers[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}

class Main6_1{
    // 双指针法
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return new int[0];
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left, right};
            } else if(sum < target){
                left++;
            } else{
              right--;
            }
        }
        return new int[0];
    }
}
