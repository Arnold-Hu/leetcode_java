//Say you have an array for which the ith element is the price of a given stock on day i.
//
//    Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//    Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//    Example 1:
//
//    Input: [3,3,5,0,0,3,1,4]
//    Output: 6
//    Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//    Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//    Example 2:
//
//    Input: [1,2,3,4,5]
//    Output: 4
//    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.5
//    Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//    engaging multiple transactions at the same time. You must sell before buying again.
//    Example 3:
//
//    Input: [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transaction is done, i.e. max profit = 0.

import java.util.Arrays;
import javax.xml.bind.SchemaOutputResolver;

public class P123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int[] left = findFirstSell(prices);
        int[] right = findSecondSell(prices);
        for (int i = 1; i<prices.length - 1; i++) {
            max = Math.max(max, left[i] + right[i]);
        }

        max = Math.max(max, left[prices.length-1]);

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return max;
    }

    public int[] findFirstSell(int[] prices) {
        int[] ret = new int[prices.length];
        int lowest = prices[0];
        for (int i = 1; i<prices.length; i++) {
            if (prices[i] > lowest) {
                ret[i] = Math.max(ret[i-1], prices[i] - lowest);
            } else if (prices[i] <= lowest) {
                ret[i] = ret[i-1];
                lowest = prices[i];
            }
        }

        return ret;
    }

    public int[] findSecondSell(int[] prices) {
        int[] ret = new int[prices.length];
        int highest = prices[prices.length-1];
        for (int i = prices.length-2; i>=0; i--) {
            if (prices[i] < highest) {
                ret[i] = Math.max(ret[i+1],  highest - prices[i]);
            } else if (prices[i] >= highest) {
                highest = prices[i];
                ret[i] = ret[i+1];
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        P123 p123 = new P123();
        System.out.println(p123.maxProfit(new int[]{2,1,2,1,0,0,1}));
    }
}
