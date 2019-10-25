import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        if (nums.length == 0) {
            return null;
        }
        res.add(0);
        if (nums.length == 1) {
            return res;
        }
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.add(nums[nums.length - 1]);
        for (int i = 2; i <= nums.length; i++) {
            int index = findIndex(sorted, nums[nums.length - i]);

            System.out.println(sorted);
            System.out.println(nums[nums.length-i]);
            System.out.println(index);
            System.out.println("====");
            res.add(index);
            sorted.add(index, nums[nums.length - i]);

        }
        Collections.reverse(res);
        return res;
    }

    private int findIndex(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (list.get(mid) > target) {
                right = mid - 1;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                while (list.get(mid) == target) {
                    if (mid == left) {
                        return mid;
                    }
                    if (list.get(mid - 1) != target) {
                        return mid;
                    }
                    mid--;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        P315 p315 = new P315();
        System.out.println(p315.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
        System.out.println("[10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]");
        System.out.println("26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41");
    }
}

