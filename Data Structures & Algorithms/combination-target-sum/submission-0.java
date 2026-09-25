class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        dfs(nums, 0, 0, target, new ArrayList<>(), out);
        return out;
    }

    void dfs(int[] n, int i, int sum, int target, List<Integer> curr, List<List<Integer>> output) {
        if (sum == target) {
            output.add(curr);
            return;
        } else if (i >= n.length || sum + n[i] > target) {
            return;
        }

        List<Integer> pick = new ArrayList<>(curr);
        pick.add(n[i]);
        dfs(n, i, sum + n[i], target, pick, output); //pick
        dfs(n, i + 1, sum, target, curr, output); //skip
    }
}
