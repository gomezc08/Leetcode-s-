import java.util.*;

/*
 * 228. Summary Ranges
 * 
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums
 * Each range [a,b] in the list should be output as:
 *  "a->b" if a != b
 *  "a" if a == b
 */


class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ranges = new ArrayList<String>();
        int start = 0;
        for(int end = 0; end < nums.length; end++) {
            System.out.print("Checking for : " + nums[end] + " : ");
            if(!(nums[start] == (nums[end] - (end - start))) || end == nums.length - 1) {
                if(end == start) {
                    ranges.add(String.valueOf(nums[end]));
                    System.out.println("less than 1");
                }
                else {
                    System.out.println("gt than 1");
                    ranges.add(nums[start] + "->" + nums[end]);
                }
                start = end;
            }
            System.out.println("");
        }
        return ranges;
    }
    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(s.summaryRanges(nums));
    }
}