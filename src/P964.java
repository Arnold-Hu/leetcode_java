import java.util.HashMap;
import java.util.Map;

public class P964 {
//    public int leastOpsExpressTarget(int x, int target) {
//        Map<Pair<Integer, Integer>, Integer> mem = new HashMap<>();
//
//
//        return leastOpsExpressTarget(x, target, mem);
//    }
//
//    private int leastOpsExpressTarget(int x, int MaxPower, int target, Map<Pair<Integer, Integer>, Integer> mem) {
//
//        if (mem.containsKey(target)) {
//            return mem.get(target);
//        }
//        int xx = x;
//        int power = 1;
//        while (xx < target) {
//            xx *= x;
//            power++;
//        }
//        System.out.println(" target is " + target + " xx is " + xx);
//        int downNumber = power - 1 + leastOpsExpressTarget(x, target - xx / x, mem);
//        int toUpperNumber = power + leastOpsExpressTarget(x, xx - target, mem);
//
//        int ret = Math.min(toUpperNumber, downNumber);
//        mem.put(target, ret);
//        return ret;
//    }

    public static void main(String[] args) {
//        P964 p964 = new P964();
//        System.out.println(p964.leastOpsExpressTarget(3, 19));
    }
}
