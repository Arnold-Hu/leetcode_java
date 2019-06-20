import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//    Note: The solution set must not contain duplicate subsets.
//
//    Example:
//
//    Input: [1,2,2]
//    Output:
//    [
//    [2],
//    [1],
//    [1,2,2],
//    [2,2],
//    [1,2],
//    []
//    ]
public class P90 {
    public static void main(String[] args) {
        P90 p90 = new P90();
        System.out.println(p90.subsetsWithDup(new int[] {1,2,2}));
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        run(nums, res, stack, indexStack, 0);

        return res;



    }

    public void run(int[] nums, List<List<Integer>> res, Stack<Integer> stack, Stack<Integer> indexStack, int index) {
        System.out.println(index);
        System.out.println(stack);
        System.out.println(indexStack);
        System.out.println("============");
        if (index >= nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        // not use
        run(nums, res, stack, indexStack, index + 1);

        if (!(index >= 1 && nums[index-1] == nums[index] && (indexStack.size() == 0 || indexStack.peek() != index - 1))) {
            stack.add(nums[index]);
            indexStack.add(index);
            run(nums, res, stack, indexStack, index + 1);
            stack.pop();
            indexStack.pop();
        }

    }


}
