package HOT100;

public class Main206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class Main206_1{
    public ListNode reverseList(ListNode head){
        ListNode ans = null;
        for (ListNode x = head; x != null; x = x.next){
            ans = new ListNode(x.val, ans);
        }
        return ans;
    }
}
