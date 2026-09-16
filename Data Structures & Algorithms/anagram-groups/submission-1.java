class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String k = new String(arr);
            map.computeIfAbsent(k, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList(map.values());
    }
}
