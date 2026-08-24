class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i-1];
        }

        int[] postfix = new int[nums.length];
        postfix[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i --) {
            postfix[i] = nums[i] * postfix[i + 1];
        }

        int[] result = new int [nums.length];
        for(int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                result[i] = postfix[i + 1];
            }
            else if (i == nums.length - 1) {
                result[i] = prefix[i - 1];
            }
            else {
                result[i] = prefix[i - 1] * postfix [i + 1];
            }
        }
        return result;
    }
}  
