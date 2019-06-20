//
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//    Assume a BST is defined as follows:
//
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.
//
//
//    Example 1:
//
//    2
//    / \
//    1   3
//
//    Input: [2,1,3]
//    Output: true
//    Example 2:
//
//    5
//    / \
//    1   4
//    / \
//    3   6
//
//    Input: [5,1,4,null,null,3,6]
//    Output: false
//    Explanation: The root node's value is 5 but its right child's value is 4.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val > max || root.val < min) {
            return false;
        }
        return isValidBST(root.left, min, (long)root.val - 1) && isValidBST(root.right, (long)root.val + 1, max);

    }
}
