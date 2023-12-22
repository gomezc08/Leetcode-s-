/*
 * 322. Coin Change

 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
*/

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Initialize memo array with a value greater than the maximum possible number of coins
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);

        // Base case: 0 coins needed to make change for 0 amount
        memo[0] = 0;

        // Recursive bottom-up case
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    memo[i] = Math.min(memo[i], 1 + memo[i - coin]);
                }
            }
        }

        // If memo[amount] is still greater than amount, no valid combination found
        return memo[amount] > amount ? -1 : memo[amount];
    }
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {1,2,5};
        System.out.println(c.coinChange(coins, 11));
    }
}
