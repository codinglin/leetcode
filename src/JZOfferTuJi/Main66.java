package JZOfferTuJi;

import java.util.HashMap;
import java.util.Map;

public class Main66 {
}

class MapSum {
    Map<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getKey().startsWith(prefix)){
                sum += entry.getValue();
            }
        }
        return sum;
    }
}
