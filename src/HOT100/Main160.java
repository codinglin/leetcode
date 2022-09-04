package HOT100;

import java.util.HashSet;
import java.util.Set;

public class Main160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode dummyNode = new ListNode(0, null);
        while (headA.next!=null){
            while(headB.next!=null){
                if(headA.val==headB.val){
                    dummyNode.next=headA;
                    while (headA.next!=null && headB.next!=null){
                        if(headA.next.val == headB.next.val){
                            headA = headA.next;
                            headB = headB.next;
                        }
                    }
                    if(headA==null && headB==null){
                        return dummyNode.next;
                    }
                }else {
                    dummyNode.next = null;
                    headB = headB.next;
                }
            }
            headA = headA.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arrayA = {4, 1, 8, 4, 5};
        int[] arrayB = {5, 6, 1, 8, 4,5};
        ListNode headA = buildList(arrayA);
        ListNode headB = buildList(arrayB);
        getIntersectionNode(headA, headB);
    }

    private static ListNode buildList(int[] a){
        ListNode dummyNode = new ListNode(0, null);
        ListNode root = dummyNode;
        for(int i=0; i<a.length; i++){
            ListNode node = new ListNode(a[i]);
            root.next = node;
            root = root.next;
        }
        return dummyNode.next;
    }
}

class Main160_1{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if(set.contains(headB)){
                return headB;
            }else{
                headB = headB.next;
            }
        }
        return null;
    }
}

class Main160_2{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA!=pB){
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }
        return pA;
    }
}
