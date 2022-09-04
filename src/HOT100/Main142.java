package HOT100;

import java.util.HashSet;
import java.util.Set;

// Definition for singly-linked list.
public class Main142 {

    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null){
            if(visited.contains(pos)){
                return pos;
            }else {
                visited.add(pos);
            }
            pos=pos.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
