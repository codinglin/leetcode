package HOT100;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        int length = length(head);
        ListNode cur = dummy;
        for(int i=1; i<length-n+1;++i){
            cur = cur.next;
        }
        cur.next=cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int length(ListNode head){
        int length=0;
        ListNode temp=head;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    public ListNode getNode(ListNode head, int index){
        if(index<1 || head==null){
            return null;
        }
        if(index==1){
            return head;
        }
        ListNode temp = head;
        int j=1;
        while (head.next!=null&&j<index){
            temp=temp.next;
            j++;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}

class MyLink{

    /**
     * 向链表中插入数据
     * @param d
     */
    public void addNode(ListNode head,int d){
        ListNode newNode = new ListNode(d);
        if(head==null){
            head = newNode;
        }else{
            ListNode temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }

    public int length(ListNode head){
        int length=0;
        ListNode temp=head;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    public ListNode getElement(ListNode head, int i){
        if(i<1 || head==null){
            return null;
        }
        if(i==1){
            return head;
        }
        ListNode temp = head;
        int j=1;
        while (head.next!=null&&j<i){
            temp=temp.next;
            j++;
        }
        return temp;
    }

    /**
     * 删除指定位置上的结点
     * @param index
     * @return
     */
    public boolean deleteNode(ListNode head,int index){
        if(index<1 || index>length(head)){
            return false;
        }
        ListNode p = getElement(head, index-1);
        ListNode q = p.next;
        p.next=q.next;
        return true;
    }
}