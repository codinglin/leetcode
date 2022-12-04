package NiukeTOP101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BM89 {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if(intervals.size() == 0){
            return res;
        }
        if(intervals.size() == 1){
            res.add(intervals.get(0));
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                    return o1.start - o2.start;
                }else{
                    return o1.end - o2.end;
                }
            }
        });
        // 放入第一个区间
        res.add(intervals.get(0));
        int count = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval o1 = intervals.get(i);
            Interval origin = res.get(count);
            if(o1.start > origin.end){
                res.add(o1);
                count++;
            }else{
                // 区间有重叠，更新结尾
                res.remove(count);
                Interval s = new Interval(origin.start, o1.end);
                if(o1.end < origin.end)
                    s.end = origin.end;
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1 ,3));
        merge(intervals);
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
