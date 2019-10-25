public class P234 {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp= temp.next;
        }
        if (len <= 1) {
            return true;
        }
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        for (int i = 0; i < len/2; i++) {
            cur = cur.next;
        }

        while (cur != null) {
            temp = cur;
            cur = cur.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }

        newHead = newHead.next;

        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            } else {
                head = head.next;
                newHead = newHead.next;
            }
        }

        return true;

    }
}
