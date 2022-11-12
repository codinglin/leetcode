package NiukeTOP101;

public class BM3 {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        return null;
    }

    private void reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            //Cur_next 指向cur节点的下一个节点
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next ;
        }
    }
}
