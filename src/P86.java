//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//    You should preserve the original relative order of the nodes in each of the two partitions.
//
//    Example:
//
//    Input: head = 1->4->3->2->5->2, x = 3
//    Output: 1->2->2->4->3->5

public class P86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode newHeadLess =  new ListNode(-1);
        ListNode ori = new ListNode(-1);
        ori.next = head;

        ListNode newCur = newHeadLess;
        head = ori;
        while (head.next != null) {
            if (head.next.val >= x) {
                head = head.next;
            } else {
                newCur.next = head.next;
                head.next = head.next.next;
                newCur = newCur.next;
                newCur.next = null;
            }
        }
        newCur.next = ori.next;
        return newHeadLess.next;
    }
}
