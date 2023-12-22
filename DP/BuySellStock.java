/*
 * 121. Best Time to Buy and Sell Stock

 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

public class BuySellStock {
    public int maxProfit(int[] prices) {
        // define variables.
        int l = 0;
        int r = 1;
        int max = 0;

        // traverse through prices.
        while(r < prices.length) {
            // case 1: l < r.
            if(prices[l] < prices[r]) {
                // before update, check max.
                if(prices[r] - prices[l] > max) {
                    max = prices[r] - prices[l];
                }
                // update.
                r++;
            }
            else {
                l = r;
                r++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        BuySellStock b = new BuySellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(prices));
    }
}
