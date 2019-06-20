//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//    Note: A leaf is a node with no children.
//
//    Example:
//
//    Given the below binary tree and sum = 22,
//
//    5
//    / \
//    4   8
//    /   / \
//    11  13  4
//    /  \    / \
//    7    2  5   1
//    Return:
//
//    [
//    [5,4,11,2],
//    [5,8,4,5]
//    ]

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new LinkedList<>();
        Stack<Integer> temp = new Stack<>();
        Stack<TreeNode> nodes = new Stack<>();
        temp.add(root.val);
        nodes.add(root);
        pathSum(ret, temp, nodes, root.val, sum);
        return ret;
    }

    public void pathSum(List<List<Integer>> ret, Stack<Integer> temp, Stack<TreeNode> nodes, int sum, int target) {
        TreeNode last = nodes.peek();
        if (last.left == null && last.right == null) {
            if (sum == target) {
                ret.add(new ArrayList<>(temp));
            }
            return;
        }

        if (sum > target) {
            return;
        }

        if (nodes.peek().left != null) {
            temp.add(last.left.val);
            nodes.add(last.left);
            pathSum(ret, temp, nodes, sum + last.left.val, target);
            temp.pop();
            nodes.pop();
        }

        if (nodes.peek().right != null) {
            temp.add(last.right.val);
            nodes.add(last.right);
            pathSum(ret, temp, nodes, sum + last.right.val, target);
            temp.pop();
            nodes.pop();
        }
    }
}
