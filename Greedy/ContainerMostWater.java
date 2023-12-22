/*
 * 11. Container With Most Water

 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container. 
 */

class ContainerMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        // create our two pointer.
        int left = 0, right = height.length - 1;

        // while true.
        while(left < right) {
            int x_axis = right - left;
            int y_axis = Math.min(height[left], height[right]);
            int area = x_axis * y_axis;

            // we will update our max.
            max = Math.max(max, area);

            // we don't care about small values, so more optimal value is to go to larger.
            if(height[left] < height[right]) {
                left += 1;
            }
            else {
                right -= 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}