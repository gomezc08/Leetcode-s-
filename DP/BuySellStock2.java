/*
 * 122. Best Time to Buy and Sell Stock II

 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
*/

public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        // declare our variables.
        int l = 0, r = 1, max_profit = 0;

        // form our little loop.
        while(r < prices.length - 1) {
            // case 1: l < r.
            if(prices[l] < prices[r]) {
                // local max. 
                if(prices[r] > prices[r+1]) {
                    max_profit += prices[r] - prices[l];
                    l = r;
                    r++;
                }
                // no local max.
                else {
                    r++;
                }
            }
            // case 2: l >= r.
            else {
                l = r;
                r++;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        BuySellStock2 b = new BuySellStock2();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(prices));
    }
}
