package NiukeTOP101;

import java.util.HashMap;
import java.util.Map;

public class BM92 {
    public int maxLength (int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int slow = 0, fast = -1;
        int maxCount = 0;
        for (fast = 0; fast < arr.length; fast++) {
            map.put(arr[fast], map.getOrDefault(arr[fast], 0) +1);
            while (map.get(arr[fast]) > 1){
                map.put(arr[slow], map.getOrDefault(arr[slow], 0) - 1);
                slow ++;
            }
            maxCount = Math.max(fast - slow + 1, maxCount);
        }
        return maxCount;
    }

//    private boolean check(HashMap<Integer, Integer> map) {
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() > 1){
//                return false;
//            }
//        }
//        return true;
//    }


}
