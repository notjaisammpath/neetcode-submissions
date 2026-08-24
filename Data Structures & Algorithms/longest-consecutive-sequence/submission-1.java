class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int k : nums) {
            set.add(k);
        }
        int maxLen = 0;
        for(int k : set) {
            if(!set.contains(k - 1)) {
                int thisCount = 1;
                int curr = k;
                while(set.contains(curr + 1)) {
                    thisCount++;
                    curr++;
                }
                if(thisCount > maxLen) {
                    maxLen = thisCount;
                }
            }
        }
        return maxLen;
    }
}
