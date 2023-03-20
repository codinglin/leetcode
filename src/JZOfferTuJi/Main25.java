package JZOfferTuJi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 反转链表方法
 */
public class Main25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseNode(l1);
        l2 = reverseNode(l2);
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        while (l1 != null || l2 != null || carry != 0){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            ListNode tmp = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            head.next = tmp;
            head = head.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return reverseNode(dummyNode.next);
    }

    private ListNode reverseNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head.next != null){
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

    private ListNode reverseNode1(ListNode head) {
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

/**
 * 栈
 */
class Main25_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = !stack1.isEmpty() ? stack1.pollFirst() : 0;
            int b = !stack2.isEmpty() ? stack2.pollFirst() : 0;
            ListNode tmp = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            dummy.next = tmp;
            tmp.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }
}
