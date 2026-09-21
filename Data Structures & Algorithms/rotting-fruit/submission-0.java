class Solution {
    public int orangesRotting(int[][] grid) {
        // find all rotten fruit
        // bfs each level, just track maxlevel and visited set?

        // loop through after and see if there are any not in the visited set and fresh in the
        // representation
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                for (int[] d : dirs) {
                    int r = p[0] + d[0], c = p[1] + d[1];
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
                        continue;
                    if (grid[r][c] != 1)
                        continue;
                    grid[r][c] = 2;
                    fresh--;
                    q.offer(new int[] {r, c});
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
