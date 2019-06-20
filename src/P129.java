//
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//    An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//    Find the total sum of all root-to-leaf numbers.
//
//    Note: A leaf is a node with no children.
//
//    Example:
//
//    Input: [1,2,3]
//    1
//    / \
//    2   3
//    Output: 25
//    Explanation:
//    The root-to-leaf path 1->2 represents the number 12.
//    The root-to-leaf path 1->3 represents the number 13.
//    Therefore, sum = 12 + 13 = 25.
//    Example 2:
//
//    Input: [4,9,0,5,1]
//    4
//    / \
//    9   0
//    / \
//    5   1
//    Output: 1026
//    Explanation:
//    The root-to-leaf path 4->9->5 represents the number 495.
//    The root-to-leaf path 4->9->1 represents the number 491.
//    The root-to-leaf path 4->0 represents the number 40.
//    Therefore, sum = 495 + 491 + 40 = 1026.

public class P129 {
    int sum;

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        sum(root, 0);
        return sum;
    }

    public void sum(TreeNode root, int parentVal) {
        if (root.left == null && root.right == null) {
            sum+=parentVal*10 + root.val;
            return;
        }

        if (root.left != null) {
            sum(root.left, parentVal*10 + root.val);
        }

        if (root.right != null) {
            sum(root.right, parentVal*10 + root.val);
        }
    }
}
