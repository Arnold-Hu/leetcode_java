//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
//    Example:
//
//    Input: 3
//    Output:
//    [
//    [1,null,3,2],
//    [3,2,null,1],
//    [3,1,null,null,2],
//    [2,1,3],
//    [1,null,2,null,3]
//    ]
//    Explanation:
//    The above output corresponds to the 5 unique BST's shown below:
//
//    1         3     3      2      1
//    \       /     /      / \      \
//    3     2     1      1   3      2
//    /     /       \                 \
//    2     1         2                 3

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int left, int right) {
        if (left > right) {
            return Collections.singletonList(null);
        }

        if (left == right) {
            return Collections.singletonList(new TreeNode(left));
        }

        List<TreeNode> ret = new LinkedList<>();

        for (int i=left; i<=right; i++) {
            for (TreeNode leftSolution : generateTrees(left, i-1)) {
                for (TreeNode rightSolution : generateTrees(i+1, right)) {
                    TreeNode center = new TreeNode(i);
                    center.left = leftSolution;
                    center.right = rightSolution;
                    ret.add(center);
                }
            }
        }

        return ret;
    }
}
