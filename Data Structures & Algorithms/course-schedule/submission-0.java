class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // num -> list of prereqs
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] state = new int[numCourses];
        // 0 unvisited, 1 in prog, 2 seen and done
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (checkCycle(i, adj, state))
                return false;
        }
        return true;
    }

    boolean checkCycle(int i, ArrayList<ArrayList<Integer>> adj, int[] state) {
        state[i] = 1;
        for (int c : adj.get(i)) {
            if (state[c] == 1) {
                return true;
            } else if (state[c] == 0 && checkCycle(c, adj, state))
                return true;
        }
        state[i] = 2;
        return false;
    }
}
