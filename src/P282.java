//Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class P282 {
    public List<String> addOperators(String num, int target) {
        int[] nums = new int[num.length()];
        char[] chars = num.toCharArray();
        for (int i = 0; i < num.length(); i++) {
            nums[i] = chars[i] - '0';
        }

        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(ret, sb, nums, 0, 0, 0, target);
        return ret;
    }


    private void dfs(List<String> ret, StringBuilder sb, int[] nums, int index, long buffer, long result, int target) {
        if (index == nums.length) {
            if (result + buffer == target) {
                ret.add(sb.toString());
            }
        }

        long x = 0;
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[index] == 0) {
                break;
            }
            x = x * 10 + nums[i];
            int oriLen = sb.length();
            if (index == 0) {
                sb.append(x);
                dfs(ret, sb, nums, i + 1, x, result, target);
                sb.setLength(oriLen);
            } else {
                sb.append('-');
                sb.append(x);
                dfs(ret, sb, nums, i + 1, -x, result + buffer, target);
                sb.setLength(oriLen);

                sb.append('+');
                sb.append(x);
                dfs(ret, sb, nums, i + 1, x, result + buffer, target);
                sb.setLength(oriLen);

                sb.append('*');
                sb.append(x);
                dfs(ret, sb, nums, i + 1, buffer * x, result, target);
                sb.setLength(oriLen);
            }
        }

    }

    public static void main(String[] args) {
        P282 p282 = new P282();
        System.out.println(p282.addOperators("2147483648", -2147483648));
    }
}
