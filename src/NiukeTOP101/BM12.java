package NiukeTOP101;

public class BM12 {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // 链表为空或者只有一个元素，直接就是有序的
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        // 右边的指针到达末尾时，中间的指针指向该链表的中间
        while(right != null && right.next != null){
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        // 断开左段的链表
        left.next = null;
        // 分成两段排序，合并排序好的两段
        return merge(sortInList(head), sortInList(mid));
    }

    //合并两段有序链表
    ListNode merge(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null){
            return pHead2;
        }
        if(pHead2 == null){
            return pHead1;
        }
        // 加一个表头
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        // 两个链表都要不为空
        while (pHead1 != null && pHead2 != null){
            // 取较小值的节点
            if(pHead1.val <= pHead2.val){
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else{
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }
        //哪个链表还有剩，直接连在后面
        if(pHead1 != null)
            cur.next = pHead1;
        else
            cur.next = pHead2;
        //返回值去掉表头
        return head.next;
    }
}
