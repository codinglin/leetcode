package JZOffer2;

import java.util.*;

public class Main30 {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;

    public Main30() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val){
        // 快速判断val是否已经存在于集合中
        if(map.containsKey(val)){
            return false;
        }
        // 将val保存在map和list中
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val){
        // 判断val是否存在于集合中
        int valIndex = map.getOrDefault(val, -1);
        if(valIndex == -1){
            return false;
        }
        // list中最后一个元素的下标
        int insteadValIndex = list.size() - 1;
        if(valIndex != insteadValIndex){
            // 将val和list[最后一个元素]的值再list中交换
            int insteadVal = list.get(insteadValIndex);
            list.set(valIndex, insteadVal);
            map.put(insteadVal, valIndex);
        }
        // 在map和list中取出val
        map.remove(val);
        list.remove(insteadValIndex);
        return true;
    }

    public int getRandom(){
        return list.get(random.nextInt(list.size()));
    }
}
