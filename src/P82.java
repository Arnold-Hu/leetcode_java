//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//    Example 1:
//
//    Input: 1->2->3->3->4->4->5
//    Output: 1->2->5
//    Example 2:
//
//    Input: 1->1->1->2->3
//    Output: 2->3


public class P82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        if (newHead.next == null) {
            return newHead.next;
        }

        while (true) {
            if (cur.next.next == null) {
                break;
            }
            if (cur.next.next.next == null) {
                if (cur.next.val == cur.next.next.val) {
                    cur.next = null;
                }
                break;
            }

            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else if ( cur.next.next.val != cur.next.next.next.val) {
                cur.next = cur.next.next.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return newHead.next;
    }
}
