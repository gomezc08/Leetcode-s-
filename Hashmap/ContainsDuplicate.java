/*
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // define variables.
        int left = 0, right = nums.length - 1;
        // two pointer sliding window making sure at least k numbers apart.
        while(left < right && right - left >= k) {
            System.out.println(nums[left] + " " + nums[right]);
            // check for duplicate.
            if(nums[left] == nums[right]) {
                System.out.println("duplicate at " + left + ", " + right);
                System.out.println(nums[left] + " " + nums[right]);
                return true;
            }
            left += 1;
            right -= 1;
        }
        return false;   
    }
    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        int[] nums = {1,2,3,1,2,3};
        System.out.println(c.containsNearbyDuplicate(nums, 2));
    }
}
