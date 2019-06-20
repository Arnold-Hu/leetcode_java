//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//    You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//    Example 1:
//
//    Given 1->2->3->4, reorder it to 1->4->2->3.
//    Example 2:
//
//    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> l = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();

        ListNode n = head.next;

        int num = 0;
        while (n!=null) {
            num += 1;
            n = n.next;
        }
        n = head.next;
        int c = 0;
        while (n != null) {
            c++;
            if (c <= num/2) {
                l.add(n);
            } else {
                stack.add(n);
            }
            n = n.next;
        }





        for (int i = 0; i < l.size(); i++) {
            head.next = stack.pop();
            head = head.next;
            head.next = l.get(i);
            head = head.next;
        }

        if (stack.size() > 0) {
            head.next = stack.pop();
            head = head.next;

        }

        head.next = null;



    }
}
