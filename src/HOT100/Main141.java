package HOT100;

import java.util.HashSet;
import java.util.Set;


// Hash方法
public class Main141 {
    private Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        while (head!=null){
            if(!set.contains(head)){
                set.add(head);
            }else {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}


// 快慢指针
class Main141_1{
    public boolean hasCycle(ListNode head){
        ListNode s = head, f = head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s == f) return true;
        }
        return false;
    }
}
