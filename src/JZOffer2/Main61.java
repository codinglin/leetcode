package JZOffer2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        int n = nums1.length, m = nums2.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                queue.add(new int[]{nums1[i], nums2[j]});
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0 && queue.peek()!=null){
            List<Integer> list = new ArrayList<>();
            int[] res = queue.poll();
            list.add(res[0]);
            list.add(res[1]);
            ans.add(list);
        }
        return ans;
    }
}
