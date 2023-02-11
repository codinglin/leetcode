package problems;

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next!=null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

class LeetCode82_1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode cur = dummyNode;
        if(head == null || head.next == null) {
            return head;
        }
        while (cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
