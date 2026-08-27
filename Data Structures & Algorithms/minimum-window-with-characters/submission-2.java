class Solution {
    public String minWindow(String s, String t) {
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();

        int a = 65;

        String shortestString = "";
        int shortestLength = Integer.MAX_VALUE;

        int r = 0;
        int l = 0;

        int[] freq = new int[64];
        int numUnique = 0;
        for (char c : tArr) {
            if (freq[c - a] == 0) {
                numUnique++;
            }
            freq[c - a]++;
        }
        int good = 0;
        while (r < sArr.length) {
            freq[sArr[r] - a] -= 1;
            if (freq[sArr[r] - a] == 0) {
                good++;
            }
            while (good >= numUnique) {
                if(r - l + 1 < shortestLength) {
                    shortestString = s.substring(l, r + 1);
                    shortestLength = r - l + 1;
                }

                freq[sArr[l] - a] += 1;
                if (freq[sArr[l] - a] == 1) {
                    good--;
                }
                l++;
            }      
            r++;
        }

        return shortestString;
    }
}
