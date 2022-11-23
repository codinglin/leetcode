package NiukeTOP101;

import java.util.HashMap;

public class BM50 {
    public int[] twoSum (int[] numbers, int target) {
        int[] res = new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if(map.containsKey(temp)){
                res = new int[]{map.get(temp) + 1, i + 1};
                break;
            }else{
                map.put(numbers[i], i);
            }
        }
        return res;
    }
}
