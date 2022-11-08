package NiukeTOP101;

import java.util.Stack;

public class BM1 {
    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode cur=head, pre=null, cur_next;
        while (cur!= null){
            cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
        return pre;
    }

    /**
     * 使用栈解决
     * @param head
     * @return
     */
    public ListNode ReverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 把链表节点全部摘掉放入栈中
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        if(stack.isEmpty()){
            return null;
        }
        ListNode node = stack.pop();
        ListNode dummy = node;
        // 栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()){
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        // 最后一个节点就是反转前的头结点，一定要让他的next等于空，不然会构成环
        node.next = null;
        return dummy;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head) {
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if(head == null){
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        ListNode node = reverseListInt(next, head);
        return node;
    }
}
