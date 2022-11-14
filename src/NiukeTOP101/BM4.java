package NiukeTOP101;

public class BM4 {
    /**
     * 迭代版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur=dummy;
        while (list1!=null && list2!=null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1!=null ? list1 : list2;
        return dummy.next;
    }

    /**
     * 递归版本
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val){
            list1.next = Merge1(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }
}
