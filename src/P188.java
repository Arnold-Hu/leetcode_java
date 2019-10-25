import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hubingcheng on 2019/8/24.
// */
//
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//        设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//        注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//        示例 1:
//
//        输入: [2,4,1], k = 2
//        输出: 2
//        解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//        示例 2:
//
//        输入: [3,2,6,5,0,3], k = 2
//        输出: 7
//        解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//             随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class P188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        System.out.println(prices.length);
        prices = simplize(prices);
        System.out.println(prices.length);
        if (k > prices.length / 2) {
            int s = 0;
            for (int i=0; i<prices.length/2; i++) {
                s -= prices[i * 2];
                s += prices[i * 2 + 1];
            }
            return s;
        }
        Integer[][][] table = new Integer[prices.length][2*k+1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= 2*k; j++) {
                maxProfit(table, prices, j, i, 0);
                maxProfit(table, prices, j, i, 1);
            }
        }
        return maxProfit(table, prices, 2*k, prices.length - 1, 0);
    }

    public int[] simplize(int[] prices) {
        if (prices.length < 2) {
            return prices;
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i<prices.length - 1; i++) {
            if (prices[i] != prices[i+1]) {
                l.add(prices[i]);
            }
        }
        l.add(prices[prices.length-1]);

        List<Integer> res = new ArrayList<>();
        if (l.size() >= 2) {
            res.add(l.get(0));
            for (int i = 1; i< l.size() - 1; i++) {
                int x = l.get(i);
                int left = l.get(i-1);
                int right = l.get(i+1);
                    if (x > left && x > right) {
                        res.add(x);
                    } else if (x < left && x < right) {
                        res.add(x);
                    }
            }
            res.add(l.get(l.size()-1));
        } else {
            res = l;
        }
        if (res.size() > 1) {
            if (res.get(0) > res.get(1)) {
                res.remove(0);
            }
        }
        if (res.size() > 1) {
            if (res.get(res.size()-1) < res.get(res.size()-2)) {
                res.remove(res.size()-1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }


    public int maxProfit(Integer[][][] table, int[] price, int k, int days, int isHold) {
        // no stock
        if (table[days][k][isHold] != null) {
            return table[days][k][isHold];
        }

        // no stock
        int profit;
        if (k == 0) {
            if (isHold == 1) {
                profit =  Integer.MIN_VALUE;
            } else {
                profit = 0;
            }
        } else if (days == 0) {
            if (isHold == 0) {
                profit = 0;
            } else {
                profit = 0 - price[days];
            }
        } else if (isHold == 0) {
            profit =  Math.max(
                    maxProfit(table, price, k, days - 1, 0),
                    maxProfit(table, price, k - 1, days - 1, 1) + price[days]
            );
        } else {
            profit =  Math.max(
                    maxProfit(table, price, k, days - 1, 1),
                    maxProfit(table, price, k - 1, days - 1, 0) - price[days]
            );
        }

        table[days][k][isHold] = profit;
        return profit;

    }

    public static void main(String[] args) {
        P188 p188 = new P188();
        System.out.println(p188.maxProfit(2, new int[]{3, 2,2,4, 6, 5, 0, 3}));
    }
}