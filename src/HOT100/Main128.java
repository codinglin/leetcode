package HOT100;

import java.util.HashSet;
import java.util.Set;

public class Main128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num: nums){
            num_set.add(num);
        }
        int longestNum = 0;
        for(int num: nums){
            if(num_set.contains(num-1)){
                continue;
            }
            int currentNum = num;
            int currentStreak=1;
            while (num_set.contains(currentNum+1)){
                currentNum +=1;
                currentStreak +=1;
            }
            longestNum = Math.max(longestNum, currentStreak);
        }
        return longestNum;
    }
}
