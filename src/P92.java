
//    Reverse a linked list from position m to n. Do it in one-pass.
//
//    Note: 1 ≤ m ≤ n ≤ length of list.
//
//    Example:
//
//    Input: 1->2->3->4->5->NULL, m = 2, n = 4
//    Output: 1->4->3->2->5->NULL

import java.util.Stack;

public class P92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode tail = newHead;
        // to the head of change
        for (int i=1; i<m;i++) {
            tail = tail.next;
        }

        Stack<ListNode> s = new Stack<>();



        for (int i=0; i<n-m; i++) {
            s.add(tail.next);
            tail.next = tail.next.next;
        }

        for (int i=0; i<n-m; i++) {
            ListNode node = s.pop();
            node.next = tail.next;
            tail.next = node;
            tail = tail.next;
        }

        return newHead.next;

    }
}
