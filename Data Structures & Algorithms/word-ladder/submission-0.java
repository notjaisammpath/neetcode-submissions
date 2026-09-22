class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char[] curr = q.poll().toCharArray();
                if((new String(curr)).equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < curr.length; j++) {
                    char[] temp = Arrays.copyOf(curr, curr.length);
                    for (int k = 0; k < 26; k++) {
                        temp[j] = (char) ('a' + k);
                        String next = new String(temp);
                        if(set.remove(next)) q.offer(next);
                    }
                }
            }
            level ++;
        }
        return 0;
    }
}
