import javafx.util.Pair;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        List<Integer> ret = new LinkedList<>();
        stack.add(new Pair<>(root, false));
        while (stack.size() > 0) {
            Pair<TreeNode, Boolean> n = stack.pop();
            if (n.getKey() == null) {
                continue;
            }
            if (n.getValue()) {
                ret.add(n.getKey().val);
            } else {
                stack.push(new Pair<>(n.getKey(), true));
                stack.push(new Pair<>(n.getKey().right, false));
                stack.push(new Pair<>(n.getKey().left, false));
            }
        }

        return ret;

    }
}
