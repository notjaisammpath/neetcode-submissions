class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int permLen = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(int i = 0; i <= arr2.length - arr1.length; i++) {
            int[] freq = new int[26];
            
            for(int j = 0; j < arr1.length; j++) {
                freq[arr1[j] - 97]++;
                freq[arr2[i + j] - 97]--;
            }


            boolean good = true;
            for(int k : freq) {
                good = k == 0 ? good : false;
            }
            if (good) 
                return true;
        }
        return false;
    }
}
 