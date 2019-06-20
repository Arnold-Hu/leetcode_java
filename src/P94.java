//Given a binary tree, return the inorder traversal of its nodes' values.
//
//    Example:
//
//    Input: [1,null,2,3]
//    1
//    \
//    2
//    /
//    3
//
//    Output: [1,3,2]
//    Follow up: Recursive solution is trivial, could you do it iteratively?

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (null == root) {
            return list;
        }
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.empty()) {
            TreeNode listNode = stack.pop();
            list.add(listNode.val);
            TreeNode right = listNode.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }

        }
        return list;

    }
}
