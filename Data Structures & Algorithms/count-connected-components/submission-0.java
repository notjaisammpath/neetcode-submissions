class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = n;
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1], parent))
                count--;
        }
        return count;
    }

    boolean union(int i, int j, int[] p) {
        int ra = findP(i, p);
        int rb = findP(j, p);
        if (ra == rb)
            return false;
        p[ra] = rb;
        return true;
    }

    int findP(int i, int[] p) {
        if (p[i] != i) {
            p[i] = findP(p[i], p);
        }
        return p[i];
    }
}
