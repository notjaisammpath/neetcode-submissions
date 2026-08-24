class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
                        if (i > 0 && nums[i] == nums[i - 1]) continue;

            int first = -nums[i];
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                if((nums[j] + nums[k]) > first) {
                    k--;
                }
                else if ((nums[j] + nums[k]) < first) {
                    j++;
                }
                else {
                    List<Integer> entry = new ArrayList<>();
                    entry.add(nums[i]);
                    entry.add(nums[j]);
                    entry.add(nums[k]);
                    result.add(entry);
                    
                    j++;
                    k--;
                    while (j < k && j < n - 1 && nums[j] == nums[j - 1]) j++;
                while (j < k && k > i + 2 && nums[k] == nums[k + 1]) k--;
                }
                
            }
        }
        return result;
    }
}
