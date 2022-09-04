package problems;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


/*
* 闭合为环
* 思路及算法：
*   记给定链表的长度为n，注意到当向右移动的次数k>=n时,我们仅需要向右移动k mod n次即可。
*   因为每n次移动都会让链表变为原状。新链表的最后一个节点为原链表的第(n-1)-(k mod n)个节点(从0开始计数).
*   先将给定的链表连接成环,然后将指定位置断开。
*   首先计算出链表的长度n,并找到该链表的末尾节点，将其与头部相连。
*   这样就得到了闭合为环的链表。然后找到新链表的最后一个节点（即原链表的第(n-1)-(k mod n)个节点），
*   将当前闭合为环的链表断开，即可。
*   特别地，当链表长度不大于1，或者k为n的倍数时，新链表将与原链表相同。
* */
public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null){
            return head;
        }
        int n=1;
        ListNode iter = head;
        while (iter.next!=null){
            iter = iter.next;
            n++;
        }
        int shift = n - k%n;
        if(shift==n){
            return head;
        }
        iter.next=head;
        while (shift-- > 0){
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
