class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> out = new ArrayList<>();
        for(int i = 0; i < intervals.length;) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i < intervals.length && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            out.add(new int[]{start, end});
        }
        return out.toArray(new int[0][]);
    }
}
