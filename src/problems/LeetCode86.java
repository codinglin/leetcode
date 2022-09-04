package problems;

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode preCur = null, cur = head, preNext = null, next = head;
        while(next!=null){
            if(next.val>=x){
                preNext=next;
                next=next.next;
            }else {
                if(cur!=next){
                    if(preCur == null){
                        head = next;
                    }else {
                        preCur.next = next;
                    }
                    preNext.next=next.next;
                    next.next=cur;
                    preCur=next;
                    next=preNext.next;
                }else{
                    preCur = cur;
                    cur=cur.next;
                    preNext=next;
                    next=next.next;
                }
            }
        }
        return head;
    }


    // small链表按顺序存储所有小于x的节点，large链表按顺序存储所有大于等于x的结点。
    // 遍历完原链表后，将small链表尾节点指向large链表的头节点即能完成对链表的分隔。
    public ListNode partition1(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while(head!=null){
            if(head.val<x){
                small.next=head;
                small=small.next;
            }else{
                large.next=head;
                large=large.next;
            }
            head=head.next;
        }
        large.next=null;
        small.next=largeHead.next;
        return smallHead.next;
    }
}
