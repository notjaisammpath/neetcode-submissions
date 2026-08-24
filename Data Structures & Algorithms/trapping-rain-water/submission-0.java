class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] prefMax = new int[len];
        int[] sufMax = new int[len];
        int amt = 0;
        prefMax[0] = height[0];
        for(int i = 1; i < len; i++) {
            if(height[i] > prefMax[i-1]) {
                prefMax[i] = height[i];
            }
            else {
                prefMax[i] = prefMax[i-1];
            }
        }

        sufMax[len - 1] = height[len - 1];
        for(int i = len-2; i >= 0; i--) {
            if(height[i] > sufMax[i+1]) {
                sufMax[i] = height[i];
            }
            else {
                sufMax[i] = sufMax[i+1];
            }
        }

        for(int i = 0; i < len; i++) {
            amt += Math.min(prefMax[i], sufMax[i]) - height[i];
        }
        // for(int j : prefMax) {
        //     System.out.println(j);
        // }

        // System.out.println(
        // "-------"
        // );
        // for(int j : sufMax) {
        //     System.out.println(j);
        // }


        return amt;
    }
}
