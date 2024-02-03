/*
 * 128. Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // define variables.
        int longest_count = 0;
        // add nums as a set.
        HashSet<Integer> h = new HashSet<>();
        for(int i : nums) {
            h.add(i);
        }

        // go through nums and check if the next value is in our array.
        for(int i : nums) {
            int count = longestConsecutiveHelper(h, i, 1);
            // update longest_count.
            longest_count = Math.max(longest_count, count);
        }
        return longest_count;
    }

    public int longestConsecutiveHelper(HashSet<Integer> h, int value, int count) {
        // check if next value is there. 
        while(h.contains(value+1)) {
            count += 1;
            value += 1;
        }
        // return count once we have our sequence.
        return count;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(l.longestConsecutive(nums));
    }
}
