//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
//    Example:
//
//    Input:
//    [
//    1->4->5,
//    1->3->4,
//    2->6
//    ]
//    Output: 1->1->2->3->4->4->5->6

import java.util.Arrays;

public class P23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        if (lists.length == 2) {
            return merge2List(lists[0], lists[1]);
        }

        return merge2List(
            mergeKLists(Arrays.<ListNode>copyOfRange(lists,0, lists.length /2)),
            mergeKLists(Arrays.<ListNode>copyOfRange(lists, lists.length/2, lists.length)));
    }


    ListNode merge2List(ListNode node1, ListNode node2){
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        ListNode head;

        if (node1.val > node2.val) {
            head = node2;
            node2 = node2.next;
        } else {
            head = node1;
            node1 = node1.next;
        }

        ListNode tail = head;

        while (true) {
            if (node1 == null) {
                tail.next = node2;
                break;
            }

            if (node2 == null) {
                tail.next = node1;
                break;
            }

            if (node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
                tail = tail.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
                tail = tail.next;
            }
        }

        return head;
    }


}
