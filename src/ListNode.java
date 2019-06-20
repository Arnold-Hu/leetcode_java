public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        while (next != null) {
            sb.append(val);
            sb.append("->");
            sb.append(next);
        }

        return sb.toString();
    }
}
