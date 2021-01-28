// https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for(int i = 0; i < heights.length; i++) {
            int l = i, r = i;
            while(l > 0 && heights[l - 1] >= heights[i]) l--;
            while(r < heights.length - 1 && heights[r + 1] >= heights[i]) r++;
            area = Math.max(area, heights[i] * (r - l + 1));
        }
        
        return area;
    }
}