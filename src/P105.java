//
//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//    Note:
//    You may assume that duplicates do not exist in the tree.
//
//    For example, given
//
//    preorder = [3,9,20,15,7]
//    inorder = [9,3,15,20,7]
//    Return the following binary tree:
//
//    3
//    / \
//    9  20
//    /  \
//    15   7

public class P105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length -1, inorder, 0, inorder.length-1 );
    }

    public TreeNode buildTree(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2) {
        if (left1 > right1){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[left1]);
        int i = left2;
        for (; i<=right2; i++) {
            if (inorder[i] == preorder[left1]) {
                break;
            }
        }

        treeNode.left = buildTree(preorder, left1 + 1, left1 + (i - left2), inorder, left2, i-1);
        treeNode.right = buildTree(preorder, left1+ (i - left2) +1, right1, inorder, i+1, right2);
        return treeNode;

    }
}
