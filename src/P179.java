import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hubingcheng on 2019/8/24.
 */

//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
//
//        示例 1:
//
//        输入: [10,2]
//        输出: 210
//        示例 2:
//
//        输入: [3,30,34,5,9]
//        输出: 9534330
//        说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/largest-number
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class P179 {
//    public String largestNumber(int[] nums) {
//        List<List<Integer>> numbers = new ArrayList<>(10);
//        for (int i = 0 ; i < 10 ; i++) {
//            numbers.add(new LinkedList<Integer>());
//        }
//
//        for (int n : nums) {
//            numbers.get(9 - (String.valueOf(n).charAt(0) - 48)).add(n);
//        }
//        System.out.println(numbers);
//
//        for (int i = 0; i< 10; i++) {
//            int head = 9- i;
//            numbers.set(i, numbers.get(i).stream().sorted((l, r) -> {
//                if (l == r) return 0;
//                int flag = 0;
//                String ll = String.valueOf(l);
//                String rr = String.valueOf(r);
//
//                for (int count=0; count < Math.max(ll.length(), rr.length());  count++) {
//                    int lll = count >= ll.length() ? head : ll.charAt(count) - 48;
//                    int rrr = count >= rr.length() ? head : rr.charAt(count) - 48;
//                    if (lll > rrr) return -1;
//                    if (rrr > lll) return 1;
//                    if (lll > head) {
//                        flag =
//                    }
//                }
//                return 0;
//            }).collect(Collectors.toList()));
//        }
//        System.out.println(numbers);
//
//        StringBuilder sb = new StringBuilder();
//        numbers.forEach(list -> list.forEach(sb::append));
//
//        return sb.toString();
//
//    }
    public static void main(String[] args) {
        P179 p179 = new P179();
//        System.out.println(p179.largestNumber(new int[]{30,3,34,5,9}));
    }
//
//        List<Integer> list = new LinkedList<>();
//        int head = 3;
//        list.add(3);
//        list.add(30);
//        list.add(34);
//
//
//        System.out.println(list.stream().sorted((l, r) -> {
//            String ll = String.valueOf(l);
//            String rr = String.valueOf(r);
//
//            System.out.println("ll " + ll);
//            System.out.println("rr " + rr);
//            for (int count=0; count < Math.max(ll.length(), rr.length());  count++) {
//                System.out.println("count " + count);
//                int lll = count >= ll.length() ? head : ll.charAt(count) - 48;
//                int rrr = count >= rr.length() ? head : rr.charAt(count) - 48;
//                if (lll > rrr) return -1;
//                if (rrr > lll) return 1;
//
//            }
//            return 0;
//        }).collect(Collectors.toList()));
//    }
}
