class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) {
            return false;
        }
        // 1 : (1, 2, 3)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] k : edges) {
            adj.get(k[0]).add(k[1]);
            adj.get(k[1]).add(k[0]);
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int k = q.poll();
                if(seen.contains(k)) continue;
                else {
                    seen.add(k);
                    for (int f : adj.get(k)) {
                        if(!seen.contains(f))
                            q.offer(f);
                    }
                }
            }
        }
        return seen.size() == n;
    }
}
