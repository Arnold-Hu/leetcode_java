import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hubingcheng on 2019/8/24.
 */

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//        示例:
//
//        输入: [1,2,3,null,5,null,4]
//        输出: [1, 3, 4]
//        解释:
//
//        1            <---
//        /   \
//        2     3         <---
//        \     \
//        5     4       <---
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class P199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> l1 = new ArrayList<>();
        l1.add(root);
        List<TreeNode> l2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        // bfs
        while (l1.size() > 0) {
            for (TreeNode treeNode : l1) {
                if (treeNode.left != null) {
                    l2.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    l2.add(treeNode.right);
                }
            }
            res.add(l1.get(l1.size()-1).val);
            l1 = l2;
            l2 = new ArrayList<>();
        }

        return res;
    }
}
