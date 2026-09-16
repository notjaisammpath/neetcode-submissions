class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int k : nums) {
            set.add(k);
        }
        int longest = 0;
        for(int k : nums) {
            if(!set.contains(k - 1)) { //start of a sequence
                int length = 1;
                while(set.contains(k + length)) {
                    length++;
                }
                if(length > longest) {
                    longest = length;
                }
            }
            
        }
        return longest;
    }
}
