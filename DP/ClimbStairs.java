/*
 * 70. Climbing Stairs

 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

import java.util.HashMap;

public class ClimbStairs {
    HashMap <Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        // base case...
        if(n <= 1) {
            return 1;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        // recurssive case...
        memo.put(n, (climbStairs(n-1) + climbStairs(n-2)));
        return memo.get(n);
    }
    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(5));
    }
}
