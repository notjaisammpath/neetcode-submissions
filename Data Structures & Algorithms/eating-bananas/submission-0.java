class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int k : piles) {
            max = Math.max(max, k);
        }

        int l = 1;
        int r = max;

        while (l < r) {
            int mid = (l + r) / 2;
            if(fastEnough(mid, piles, h)) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }

    boolean fastEnough(int s, int[] piles, int h) {
        long hours = 0;
        for(int k : piles) {
            hours += (k + s - 1) / s;
        }
        return hours <= h;
    }
}
