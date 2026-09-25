class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(0, new ArrayList<>(), output, nums);
        return output;
    }

    void dfs(int ind, List<Integer> curr, List<List<Integer>> output, int[] nums) {
        if (ind == nums.length) {
            output.add(curr);
            return;
        }
        List<Integer> pick = new ArrayList<>(curr);
        pick.add(nums[ind]);
        dfs(ind + 1, pick, output, nums);
        dfs(ind + 1, new ArrayList<>(curr), output, nums);
    }
}
