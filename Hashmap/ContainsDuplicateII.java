/*
 * 219. Contains Duplicate II
 * 
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */


import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // define variables.
        HashMap<Integer, Integer> h = new HashMap<>();

        // start our loop.
        for(int i = 0; i < nums.length; i++) {
            // check: is it in nums + <= k.
            if(h.containsKey(nums[i]) && Math.abs(i - h.get(nums[i])) <= k) {
                return true;
            }

            // update and move on.
            h.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicateII c = new ContainsDuplicateII();
        int[] nums = {1,2,3,1,2,3};
        System.out.println(c.containsNearbyDuplicate(nums, 2));
    }
}