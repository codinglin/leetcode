package NiukeTOP101;

public class BM7 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null) return null;
        // 定义快慢指针
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast != null && fast.next !=null){
            // 快指针是慢指针的两倍速度
            fast = fast.next.next;
            slow = slow.next;
            // 记录快慢指针第一次相遇的结点
            if(slow == fast) break;
        }
        // 若是快指针指向null,则不存在环
        if(fast == null || fast.next == null) return null;
        // 重新指向链表头部
        fast = pHead;
        // 与第一次相遇的结点相同速度出发，相遇结点为入口结点。推导可以通过画图得出。
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
