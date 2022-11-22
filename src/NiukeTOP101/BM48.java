package NiukeTOP101;

import java.util.ArrayList;

public class BM48 {
    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        if(list.size() == 0){
            list.add(num);
        }else{
            int left = 0, right = list.size() - 1;
            while (left <= right && list.get(left) <= num){
                left ++;
            }
            list.add(left, num);
        }
    }

    public Double GetMedian() {
        if(list.size() % 2 == 0){
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) * 1.0 / 2;
        }else{
            return list.get(list.size() / 2) * 1.0;
        }
    }
}
