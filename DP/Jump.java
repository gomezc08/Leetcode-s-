/*
 * 55. Jump Game

 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */

public class Jump {
    public boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }
    public boolean canJumpHelper(int[] nums, int position) {
        int i = 0;
        // base case: at end?
        if(position >= nums.length - 1) {
            return true;
        }
        
        // base case: if we are at 0.
        else if(nums[position] == 0) {
            return false;
        }

        // loop.
        while(i < nums[position]) {
            if(canJumpHelper(nums, (position + i + 1))) {
                return true;
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args) {
        Jump j = new Jump();
        int[] nums = {3,2,1,0,4};
        System.out.println(j.canJump(nums));
    }
}
