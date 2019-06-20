//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//    Example:
//
//    Given the sorted linked list: [-10,-3,0,5,9],
//
//    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//    0
//    / \
//    -3   9
//    /   /
//    -10  5
//

import java.util.ArrayList;
import java.util.List;

public class P109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> l = new ArrayList<>();
        for (;head != null; head=head.next) {
            l.add(head.val);
        }

        return sortedListToBST(l, 0, l.size() -1);
    }

    public TreeNode sortedListToBST(List<Integer> head, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right+left) / 2;
        TreeNode treeNode = new TreeNode(head.get(mid));
        treeNode.left = sortedListToBST(head, left, mid - 1);
        treeNode.right =sortedListToBST(head, mid + 1, right);
        return treeNode;
    }
}
