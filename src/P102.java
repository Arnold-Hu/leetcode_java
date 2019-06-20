//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//    For example:
//    Given binary tree [3,9,20,null,null,15,7],
//    3
//    / \
//    9  20
//    /  \
//    15   7
//    return its level order traversal as:
//    [
//    [3],
//    [9,20],
//    [15,7]
//    ]

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> l1 = Collections.singletonList(root);
        List<TreeNode> temp;
        while (l1.size() > 0) {
            temp = new LinkedList<>();
            List<Integer> s = new LinkedList<>();
            for (TreeNode treeNode : l1) {
                s.add(treeNode.val);
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }
            ret.add(s);
            l1 = temp;
        }

        return ret;
    }
}
