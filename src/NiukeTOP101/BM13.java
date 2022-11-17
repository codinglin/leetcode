package NiukeTOP101;

import java.util.Stack;

public class BM13 {
    /**
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode left = head, mid = head.next, right = head.next.next;
        while(right != null && right.next != null){
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        left.next = null;
        ListNode newHead = reverseList(mid);
        while (head != null && newHead != null){
            if(head.val == newHead.val){
                head = head.next;
                newHead = newHead.next;
            }else{
                return false;
            }
        }
        return true;
    }

    private ListNode reverseList(ListNode mid) {
        ListNode pre = null, cur = mid, nextCur;
        while (cur != null){
            nextCur = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextCur;
        }
        return pre;
    }

    /**
     * 头插法
     * @param mid
     * @return
     */
    private ListNode insertHead(ListNode mid){
        ListNode dummy = new ListNode(-1);
        dummy.next = mid;
        ListNode pre = dummy, cur = mid, nextCur;
        while (cur.next != null){
            nextCur = cur.next;
            cur.next = nextCur.next;
            nextCur.next = pre.next;
            pre.next = nextCur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        BM13 bm2 = new BM13();
        ListNode nodeSta = new ListNode(0);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode=nodeSta;                      //指向首节点
        //这句话就相当于 ListNode nextNode = nodeSta = new ListNode(0);
        //创建链表
        int[] x = new int[]{1,2,2,1};
        for(int i=0;i<x.length;i++){
            ListNode node = new ListNode(x[i]);  //生成新的节点
            nextNode.next=node;               //把新节点连起来
            nextNode=nextNode.next;           //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，
        nextNode=nodeSta;                     //重新赋值让它指向首节点
        bm2.isPail(nextNode.next);
    }
}

/**
 * 栈逆序
 */
class BM13_1{
    public boolean isPail (ListNode head) {
        ListNode p = head;
        Stack<Integer> s = new Stack<>();
        // 辅助栈记录数据
        while (p != null){
            s.push(p.val);
            p = p.next;
        }
        p = head;
        // 正序遍历链表，从栈中弹出的内容是逆序的
        while (!s.isEmpty()){
            // 比较是否相同
            if(p.val != s.pop())
                return false;
            p = p.next;
        }
        return true;
    }
}
