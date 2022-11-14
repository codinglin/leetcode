package NiukeTOP101;

import com.sun.scenario.effect.Merge;

import java.util.ArrayList;

public class BM5 {
    /**
     * 归并排序：简单来说就是将一个数组每次划分成等长的两部分，对两部分进行排序既是子问题。对子问题继续划分，直到子问题只有1个元素。
     *      还原的时候呢，将每个子问题与它相邻的另一个子问题利用双指针的方式，1个与1个合并成2个，2个与2个合并成4个，因为这每个单独的子问题合并好的都是有序的，直到合并成原本长度的数组。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // k个链表归并排序
        return divideMerge(lists, 0, lists.size() - 1);
    }

    private ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        if(left > right){
            return null;
        }
        // 中间一个的情况
        else if(left == right){
            return lists.get(left);
        }
        // 从中间分成两段，再将合并好的两段合并
        int mid = (left + right) / 2;
        return Merge(divideMerge(lists, left, mid), divideMerge(lists, mid + 1, right));
    }

    //两个链表合并函数
    public ListNode Merge(ListNode list1, ListNode list2) {
        //一个已经为空了，直接返回另一个
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        //加一个表头
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //两个链表都要不为空
        while(list1 != null && list2 != null){
            //取较小值的节点
            if(list1.val <= list2.val){
                cur.next = list1;
                //只移动取值的指针
                list1 = list1.next;
            }else{
                cur.next = list2;
                //只移动取值的指针
                list2 = list2.next;
            }
            //指针后移
            cur = cur.next;
        }
        //哪个链表还有剩，直接连在后面
        if(list1 != null)
            cur.next = list1;
        else
            cur.next = list2;
        //返回值去掉表头
        return head.next;
    }
}

class BM5_1{
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideMerge(lists, 0, lists.size() - 1);
    }

    private ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        if(left > right){
            return null;
        }
        else if(left == right){
            return lists.get(left);
        }
        int mid = (left + right) / 2;
        return Merge(divideMerge(lists, left, mid), divideMerge(lists, mid+1, right));
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        //一个已经为空了，直接返回另一个
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        //加一个表头
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //两个链表都要不为空
        while(list1 != null && list2 != null){
            //取较小值的节点
            if(list1.val <= list2.val){
                cur.next = list1;
                //只移动取值的指针
                list1 = list1.next;
            }else{
                cur.next = list2;
                //只移动取值的指针
                list2 = list2.next;
            }
            //指针后移
            cur = cur.next;
        }
        //哪个链表还有剩，直接连在后面
        if(list1 != null)
            cur.next = list1;
        else
            cur.next = list2;
        //返回值去掉表头
        return head.next;
    }
}
