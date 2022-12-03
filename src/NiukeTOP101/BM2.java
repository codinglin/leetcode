package NiukeTOP101;

public class BM2 {
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 设置哑点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode cur_next;
        for(int i=0;i<n-m;i++){
            cur_next = cur.next;
            cur.next = cur_next.next;
            cur_next.next = pre.next;
            pre.next = cur_next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        BM2 bm2 = new BM2();
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
        bm2.reverseBetween(nextNode.next, 2, 4);
    }
}

/**
 * 双指针
 */
class BM2_1{
    // 说明：方便理解，以下注释中将用 left,right 分别代替 m,n 节点
    public ListNode reverseBetween(ListNode head, int m, int n){
        // 设置虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre= dummyNode;
        // 1.走left-1步到left的前一个结点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // 2.走right-left+1步到right结点
        ListNode rightNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }
        // 3.截取出一个子链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        // 4.切断链接
        pre.next = null;
        rightNode.next = null;
        //5.反转局部链表
        reverseLinkedList(leftNode);
        //6.接回原来的链表
        pre.next = rightNode;
        leftNode.next = cur;
        return dummyNode.next;
    }
    //反转局部链表
    private void reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            //Cur_next 指向cur节点的下一个节点
            ListNode cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next ;
        }
    }
}
