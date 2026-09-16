class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i : nums) {
            if(m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            }
            else m.put(i, 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
            q.offer(entry);
            if(q.size() > k) {
                q.poll();
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i ++) {
            result[i] = q.poll().getKey();
        }
        return result;

    }
}
