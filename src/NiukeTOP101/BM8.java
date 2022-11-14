package NiukeTOP101;

public class BM8 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        //快指针先行k步
        for(int i = 0; i < k; i++){
            if(fast != null)
                fast = fast.next;
                //达不到k步说明链表过短，没有倒数k
            else
                return null;
        }
        //快慢指针同步，快指针先到底，慢指针指向倒数第k个
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
