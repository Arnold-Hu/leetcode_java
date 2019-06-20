//Given a linked list, rotate the list to the right by k places, where k is non-negative.
//
//    Example 1:
//
//    Input: 1->2->3->4->5->NULL, k = 2
//    Output: 4->5->1->2->3->NULL
//    Explanation:
//    rotate 1 steps to the right: 5->1->2->3->4->NULL
//    rotate 2 steps to the right: 4->5->1->2->3->NULL
//    Example 2:
//
//    Input: 0->1->2->NULL, k = 4
//    Output: 2->0->1->NULL
//    Explanation:
//    rotate 1 steps to the right: 2->0->1->NULL
//    rotate 2 steps to the right: 1->2->0->NULL
//    rotate 3 steps to the right: 0->1->2->NULL
//    rotate 4 steps to the right: 2->0->1->NULL


public class P61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (k <= 0) {
            return head;
        }


        int length = 0;
        ListNode cur = head;


        while (cur != null) {
            length++;
            cur = cur.next;
        }

        if (length <= 1) {
            return head;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }
        cur = head;
        ListNode newHeadHead = head;
        for (int i = 0; i < length - 1; i++) {
            if (i == length - k - 1) {
                newHeadHead = cur;
            }
            cur = cur.next;

        }

        ListNode newHead = newHeadHead.next;
        newHeadHead.next = null;
        cur.next = head;

        return newHead;



    }
}
