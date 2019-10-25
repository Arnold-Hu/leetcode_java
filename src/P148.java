import java.util.List;

public class P148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length == 1) {
            return head;
        }

        temp = head;
        for (int i = 0; i< length / 2 - 1; i++) {
            temp = temp.next;
        }
        ListNode nextRoot = temp.next;
        temp.next = null;
        head = sortList(head);
        nextRoot = sortList(nextRoot);
        ListNode newRoot = new ListNode(-1);
        ListNode cur = newRoot;
        while (head != null && nextRoot != null) {
            if (head.val < nextRoot.val) {
                cur.next = head;
                head = head.next;
                cur = cur.next;
            } else {
                cur.next = nextRoot;
                nextRoot = nextRoot.next;
                cur = cur.next;
            }
        }
        if (head != null) {
            cur.next = head;
        } else {
            cur.next = nextRoot;
        }
        return newRoot.next;
    }
}
