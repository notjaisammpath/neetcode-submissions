class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length(); 
        int l = 0;
        int r = 0;
        int maxLen = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        while(r < len) {
            //(l - r + 1) - max(map) <= k
            if(m.containsKey(arr[r])) {
                m.put(arr[r], m.get(arr[r]) + 1);
            }
            else {
                m.put(arr[r], 1);
            }
            int max = 0;
            for(int c : m.values()) {
                max = Math.max(max, c);
            }

            while(r - l + 1 - max > k) {
                m.put(arr[l], m.get(arr[l]) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            // System.out.println("L = " + l + " R = " + r);
            r++;

        }
        return maxLen;
    }
}
