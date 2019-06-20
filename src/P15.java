
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class P15 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        Map<Integer, List<Integer>> numAndPos = new HashMap<>();
//        Set<String> retSet = new HashSet<>();
//        List<List<Integer>> ret = new LinkedList<>();
//
//        for (int i=0; i < nums.length; i++) {
//            numAndPos.putIfAbsent(nums[i], new LinkedList<>());
//            numAndPos.get(nums[i]).add(i);
//        }
//
//
//
//        for (int i=0;i < nums.length -1; i++) {
//            for (int j=i+1; j<nums.length; j++) {
//                int sum = nums[i] + nums[j];
//                if (!numAndPos.containsKey(-sum)) {
//                    continue;
//                }
//
//                for (int pos : numAndPos.get(-sum)) {
//                    if (pos != i && pos != j) {
//                        int[] a = new int[]{-sum, nums[i], nums[j]};
//                        Arrays.sort(a);
//                        String retString = String.format("%s,%s,%s", a[0], a[1], a[2]);
//                        if (!retSet.contains(retString)) {
//                            ret.add(new ArrayList<Integer>(){{add(a[0]);add(a[1]);add(a[2]);}});
//                            retSet.add(retString);
//                        }
//                    }
//                }
//            }
//        }
//
//
//        return ret;
//
//
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> rets = new HashSet<>();
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i ++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] > 0) {
                    r -= 1;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l += 1;
                } else {
                    String s = nums[i] + "," + nums[l] + "," + nums[r];
                    if (!rets.contains(s)) {
                        rets.add(s);
                        ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    }
                    l += 1;
                    r -= 1;
                }
            }
        }

        return ret;



    }

    public static void main(String[] args) {
        P15 p15 = new P15();
        p15.threeSum(new int[]{-1,0,1,2,-1,-4}).forEach(x -> System.out.println(Arrays.toString(x.toArray())));

    }
}
