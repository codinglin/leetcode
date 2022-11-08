package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 水塘抽样
 */
public class LeetCode382 {
    ListNode head;
    Random random;

    public LeetCode382(ListNode head){
        this.head = head;
        random = new Random();
    }

    public int getRandom(){
        int i = 1, ans = 0;
        for(ListNode node = head; node != null; node = node.next){
            if(random.nextInt(i) == 0){
                ans = node.val;
            }
            ++ i;
        }
        return ans;
    }
}

/**
 * 记录所有链表元素
 */
class Solution {
    List<Integer> list;
    Random random;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

