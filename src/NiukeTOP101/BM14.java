package NiukeTOP101;

public class BM14 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // 如果链表为空，不用重排
        if(head == null){
            return head;
        }
        // even开头指向第二个节点，可能为空
        ListNode even = head.next;
        // odd开头指向第一个节点
        ListNode odd = head;
        // 指向even开头
        ListNode evenHead = even;
        while (even != null && even.next !=null){
            // odd连接even的后一个，即奇数位
            odd.next = even.next;
            // odd进入后一个奇数位
            odd = odd.next;
            // even连接后一个奇数的后一位，即偶数位
            even.next = odd.next;
            // even进入后一个偶数位
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
