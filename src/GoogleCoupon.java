import java.util.HashMap;
import java.util.Map;
//Several coupons are placed in a row, and to win the prize you need to
//        pick at least 2 coupons of the same value. You can only pick consecutive coupons
//        from the row. Each coupon costs 1 coin, find the minimum number of coins needed
//        to obtain the prize or, -1 if it’s not possible.
//
//        Example 1:
//
//        Input: coupons = [5, 3, 4, 2, 3, 4, 5, 7]
//        Output: 4
//        Explanation:
//        Because you can buy coupons with values [3, 4, 2, 3] or [4, 2, 3, 4]
//        Example 2:
//
//        Input: coupons = [3, 6, 1, 9]
//        Output: -1
public class GoogleCoupon {
    public int solution(int[] coupons) {
        int windowLeft = 0;
        int windowRight = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Integer, Integer> window = new HashMap<>();
        window.put(coupons[0], 1);

        while(true) {
            windowRight = findRight(coupons, window, windowRight);
            if (windowRight == -1) {
                break;
            }
            windowLeft = findLeft(coupons, window, windowLeft);
            if (windowRight - windowLeft + 1 < minLen) {
                minLen = windowRight - windowLeft + 1;
            }
            window.put(windowLeft, 1);
            windowLeft++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLen;
        }
    }

    private int findRight(int[] coupon, Map<Integer, Integer> window, int windowRight) {
        windowRight++;
        for (;windowRight < coupon.length; windowRight++) {
            int couponId = coupon[windowRight];
            window.put(couponId, window.getOrDefault(couponId, 0) + 1);
            if (window.get(couponId) == 2) {
                return windowRight;
            }
        }
        return -1;
    }

    private int findLeft(int[] coupon, Map<Integer, Integer> window, int windowLeft) {
//        System.out.println(window);
//        System.out.println(windowLeft);
        while(window.get(coupon[windowLeft]) != 2) {
            window.remove(coupon[windowLeft]);
            windowLeft++;
        }
        return windowLeft;
    }

    public static void main(String[] args) {
        GoogleCoupon gp = new GoogleCoupon();
        System.out.println(gp.solution(new int[]{5, 3, 4, 2, 3, 4, 5, 7}));
        System.out.println(gp.solution(new int[]{3, 6, 1, 9}));
    }
}
