package NiukeTOP101;

public class BM3 {
    /**
     * 非递归方法
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int length = 0;
        ListNode pre = dummy, cur = head, temp = null;
        while (head != null){
            length ++;
            head = head.next;
        }
        // 分段使用头插法将链表反序
        for (int i = 0; i < length / k; i++) {
            // pre作为每一小段链表的头节点，负责衔接
            for (int j = 1; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                // 相当于头插法，注意：temp.next = cur是错误的，temp需要连接的不是前一节点，而是子序列的头节点
                temp.next = pre.next;
                pre.next = temp;
            }
            // 每个子序列反序列化后，pre,cur需要更新至下一子序列的头部
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 递归方法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        //边界条件判断
        if (head == null || head.next == null)
            return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null)
                return head;
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup1(tail, k);
        return newHead;
    }

    /*
        链表的反转，不是反转全部，只反转区间[head,tail)中间的节点，左闭右开区间
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode reverseLinkedList(ListNode head, ListNode pre){
        if(pre.val == -1){
            pre = null;
        }
        ListNode cur = head;
        while(cur!=null){
            //cur_next 指向cur节点的下一个节点
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next ;
        }
        return pre;
    }

    public static void main(String[] args) {
        BM3 bm3 = new BM3();
        ListNode nodeSta = new ListNode(0);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode=nodeSta;                      //指向首节点
        //这句话就相当于 ListNode nextNode = nodeSta = new ListNode(0);
        //创建链表
        int[] x = new int[]{1,2,3,4,5};
        for(int i=0;i<x.length;i++){
            ListNode node = new ListNode(x[i]);  //生成新的节点
            nextNode.next=node;               //把新节点连起来
            nextNode=nextNode.next;           //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，
        nextNode=nodeSta;                     //重新赋值让它指向首节点
        bm3.reverseKGroup(nextNode.next, 2);
    }
}
