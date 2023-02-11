package problems;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode, cur = head;
        while (cur != null) {
            ListNode t = cur;
            cur = cur.next;
            t.next = p.next;
            p.next = t;
        }
        return dummyNode.next;
    }
}
