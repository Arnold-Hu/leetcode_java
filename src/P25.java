//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//    Example:
//
//    Given this linked list: 1->2->3->4->5
//
//    For k = 2, you should return: 2->1->4->3->5
//
//    For k = 3, you should return: 3->2->1->4->5
//
//    Note:
//
//    Only constant extra memory is allowed.
//    You may not alter the values in the list's nodes, only nodes itself may be changed.

import java.util.Optional;

public class P25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(-1);
        ListNode lp = h;
        int i;
        ListNode[] nodes = new ListNode[k];
        while (isAvailable(head, k)) {
            for (i = 0; i< k ; i++) {
                nodes[i] = head;
                head = head.next;
            }
            for (i = k-1;i>=0;i--) {
                lp.next = nodes[i];
                lp = lp.next;
            }
        }
        lp.next = head;
        return h.next;
    }


    private boolean isAvailable(ListNode head, int k) {
        ListNode h = head;
        for (int i=0;i<k;i++) {
            if (h == null) {
                return false;
            }
            h = h.next;
        }
        return true;
    }
}
