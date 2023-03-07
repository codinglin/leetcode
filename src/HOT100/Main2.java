package HOT100;

public class Main2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        int n1, n2, carry = 0;
        while (l1 != null || l2 != null) {
            n1 = l1 != null ? l1.val : 0;
            n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            head.next = node;
            head = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            head.next = node;
        }
        return dummyNode.next;
    }
}
