package HOT100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 排序
public class Main169 {
    public int majorityElement(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

// 哈希表
class Main169_1{
    private Map<Integer, Integer> countNums(int[] nums){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums){
            if(!counts.containsKey(num)){
                counts.put(num, 1);
            }else{
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums){
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
                majorityEntry = entry;
            }
        }
        return majorityEntry.getValue();
    }
}

// 随机化
class Main169_2{
    private int randRange(Random rand, int min, int max){
        return rand.nextInt(max - min) + min;
    }

    private int countOccurrences(int[] nums, int num){
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums){
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while(true){
            int candidate = nums[randRange(rand, 0, nums.length)];
            if(countOccurrences(nums, candidate) > majorityCount){
                return candidate;
            }
        }
    }
}

// 分治法
class Main169_3{
    private int countInRange(int[] nums, int num, int low, int high){
        int count=0;
        for(int i=low; i<=high; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int low, int high){
        // base case: the only element in an array of size 1 is the majority element.
        if(low == high){
            return nums[low];
        }
        // recurse on left and right halves of this slice.
        int mid = (high-low)/2+low;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid+1, high);

        // if the two halves agree on the majority element, return it.
        if(left == right){
            return left;
        }

        // otherwise, count each element and return the "winner"
        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);
        return leftCount>rightCount ? left:right;
    }

    public int majorityElement(int[] nums){
        return majorityElementRec(nums, 0, nums.length-1);
    }
}

/**
 * Boyer-Moore投票算法
 * 不妨假设整个数组的众数记做a,则最初的数组中a的数量大于其余所有数。
 * 当采用count计数的时候有两种情况：
 * 1）假设candidate等于a,则当count从1变为0的过程,此区间内a的数量等于其余数的数量，因此以count=0分界线，
 *    数组右端部分的众数仍然为a。
 * 2）假设candidate不等于a,则当count从1变为0的过程，此区间内a的数量小于等于其他数的数量，因此以count=0为分界线,
 *    数组右端部分的众数仍然为a。
 * 因此,以count=0可以将整个原始数组分为若干部分,count=0右端部分的数组中的众数永远是a,最终必然会筛选出a。
 */

class Main169_4{
    public int majorityElement(int[] nums){
        int count=0;
        Integer candidate = null;
        for(int num : nums){
            if(count==0){
                candidate=num;
            }
            count+=(num==candidate)?1:-1;
        }
        return candidate;
    }
}