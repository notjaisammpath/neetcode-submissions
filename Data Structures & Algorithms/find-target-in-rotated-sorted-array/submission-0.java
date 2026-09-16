class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        int p = l;
        l = 0;
        r = nums.length - 1;
        if(target >= nums[p] && target <= nums[r]) {
            l = p;
        }
        else {
            r = p - 1;
        }

        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
