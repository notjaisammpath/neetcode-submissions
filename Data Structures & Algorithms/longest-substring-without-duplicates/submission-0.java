class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 1;
        int l = 0;
        if(s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        for(int r = 0; r < s.length(); r++) {
            if(set.contains(s.charAt(r))) {
                while(set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            len = Math.max(r - l + 1, len);
        }
        return len;
    }
}
