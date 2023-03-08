package HOT100;

public class Main23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return MergeSort(lists, 0, n - 1);
    }

    private ListNode MergeSort(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }
        if(left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return MergeTwoList(MergeSort(lists, left ,mid), MergeSort(lists, mid + 1, right));
    }

    private ListNode MergeTwoList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (a != null && b != null) {
            if(a.val <= b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next =b;
                b = b.next;
            }
            temp = temp.next;
        }
        if(a != null) {
            temp.next = a;
        }
        if(b != null) {
            temp.next = b;
        }
        return dummy.next;
    }
}
