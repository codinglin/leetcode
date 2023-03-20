package JZOfferTuJi;

public class Main26 {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = reverseList(slow.next);
        slow.next = null;
        ListNode l1 = head;
        while (l2 != null && l1 != null) {
            ListNode next = l1.next, temp = l2;
            l2 = l2.next;
            l1.next = temp;
            temp.next = next;
            l1 = next;
        }
    }

    private ListNode reverseList(ListNode head){
        ListNode cur = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = cur;
            cur = tmp;
        }
        return cur;
    }
}
