package NiukeTOP101;

public class BM16 {
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // 空链表
        if(head == null){
            return null;
        }
        ListNode res = new ListNode(-1);
        // 在链表前加一个表头
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null){
            // 遇到相邻两个节点值相同
            if(cur.next.val == cur.next.next.val){
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        // 返回时去掉表头
        return res.next;
    }
}
