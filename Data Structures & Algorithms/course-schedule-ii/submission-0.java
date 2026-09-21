class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] i : prerequisites) {
            adj.computeIfAbsent(i[0], k -> new ArrayList<Integer>()).add(i[1]);
        }

        List<Integer> out = new ArrayList<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, seen, out, adj)) {
                return new int[0];
            }
        }
        int[] arr = new int[out.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = out.get(i);
        }
        return arr;

    }

    boolean dfs(int c, Set<Integer> seen, List<Integer> output, HashMap<Integer, List<Integer>> adj) {
        if(output.contains(c)) {
            return true;
        }
        if(seen.contains(c)) {
            return false;
        }

        seen.add(c);

        for(int k : adj.computeIfAbsent(c, k -> List.of())) {
            boolean j = dfs(k, seen, output, adj);
            if(!j) return false;
        }

        seen.remove(c);
        output.add(c);
        return true;   
    }
}
