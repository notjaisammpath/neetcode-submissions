class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int area = 0;
        while (l < r) {
            int temp = (r - l) * Math.min(heights[l], heights[r]);
            if(temp > area) {
                area = temp;
            }
            if(heights[l] > heights[r]) {
                r--;
            }
            else l++;
        }
        return area;
    }
}
