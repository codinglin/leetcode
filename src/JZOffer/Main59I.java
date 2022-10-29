package JZOffer;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 单调队列
 */
public class Main59I {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1){
            return new int[]{nums[0]};
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(nums[0]);
        for (int i = 1; i < k; i++) {
            while(!queue.isEmpty() && queue.peekLast() < nums[i])
                queue.removeLast();
            queue.addLast(nums[i]);
        }
        result[0] = queue.getFirst();
        for (int i = k; i < nums.length; i++) {
            if(queue.peekFirst() == nums[i - k])
                queue.removeFirst();
            while(!queue.isEmpty() && queue.peekLast() < nums[i])
                queue.removeLast();
            queue.addLast(nums[i]);
            result[i - k + 1] = queue.peekFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,4};
        maxSlidingWindow(nums, 2);
    }
}

/**
 * 优先队列
 */
class Main59I_1{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}

class Main59I_2{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
}
