//Given a non-empty binary tree, find the maximum path sum.
//
//    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
//    Example 1:
//
//    Input: [1,2,3]
//
//    1
//    / \
//    2   3
//
//    Output: 6
//    Example 2:
//
//    Input: [-10,9,20,null,null,15,7]
//
//    -10
//    / \
//    9  20
//    /  \
//    15   7
//
//    Output: 42

public class P124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return max;
    }

    public int maxPathSum2(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = Math.max(maxPathSum2(root.left), 0);
        }
        if (root.right != null) {
            right = Math.max(maxPathSum2(root.right), 0);
        }
        int ret =  root.val + Math.max(left, right);
        max = Math.max(max, ret);
        return ret;
    }
}
