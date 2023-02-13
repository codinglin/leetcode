package problems;

public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return mergeSort(lists, 0, n - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(mergeSort(lists, left, mid), mergeSort(lists, mid + 1, right));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}

/**
 * 简单解法：顺序合并
 */
class LeetCode23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null || b == null) {
            return a != null ? a:b;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode ptr = dummyNode, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if(aPtr.val < bPtr.val) {
                ptr.next = aPtr;
                aPtr = aPtr.next;
            } else {
                ptr.next = bPtr;
                bPtr = bPtr.next;
            }
            ptr = ptr.next;
        }
        ptr.next = (aPtr != null ? aPtr : bPtr);
        return dummyNode.next;
    }
}
