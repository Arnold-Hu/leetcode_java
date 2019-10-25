//Given a complete binary tree, count the number of nodes.
//
//        Note:
//
//        Definition of a complete binary tree from Wikipedia:
//        In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//        Example:
//
//        Input:
//        1
//        / \
//        2   3
//        / \  /
//        4  5 6
//
//        Output: 6

public class P222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 1;
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
            leftDepth++;
        }

        int rightDepth = 1;
        temp = root;
        while (temp.right != null) {
            temp = temp.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            temp = root;
        }
        int baseLength = 1 << (leftDepth - 2);
        int baseDepth = 1;
        int l = 0;
        while (temp != null) {
            if (findRightTreeLeftDepth(temp.left) + baseDepth == leftDepth) {
                l += baseLength;
                temp = temp.right;
            } else {
                temp = temp.left;
            }
            baseDepth++;
            baseLength = baseLength >> 1;
        }

        int baseCount = (1 << (leftDepth - 1)) - 1;
        System.out.println(l);
        return l + baseCount;
    }


    private int findRightTreeLeftDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int depth = 1;
            while (root.right != null) {
                root = root.right;
                depth++;
            }
            return depth;
        }
    }
}
