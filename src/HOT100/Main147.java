package HOT100;

import java.util.List;

public class Main147 {
    public ListNode insertionSortList(ListNode head) {
        // 1.首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
        if (head == null) {
            return null;
        }
        // 2.链表初始化操作
        ListNode dummyHead = new ListNode(0, head); // 引入哑节点
        ListNode lastSorted = head; // 维护lastSorted为链表已经排好序的最后一个节点并初始化
        ListNode curr = head.next;  // 维护curr为待插入的元素并初始化
        // 3.插入排序
        while (curr!=null){
            if(lastSorted.val <= curr.val){
                lastSorted=lastSorted.next;
            }else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
