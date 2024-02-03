/*
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

class HouseRobber {

    public int rob(int[] nums) {
        // define variables.
        int[] dp = new int[nums.length];
        int path_1 = robHelper(dp, nums, nums.length-1);
        int path_2 = robHelper(dp, nums, nums.length-2);
        return Math.max(path_1, path_2);
    }

    public int robHelper(int[] dp, int[] nums, int n) {
        // base case 1: n < 2.
        if(n < 2) {
            return nums[n];
        } 
        
        // base case 2: n < 3.
        if(n < 3) {
            return nums[0];
        }
        // recursive case.
        return dp[n] = nums[n] + Math.max(robHelper(dp, nums, n-2), robHelper(dp, nums, n-3));
    }

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[] nums = {2,7,9,3,1};
        System.out.println(h.rob(nums));
    }
}