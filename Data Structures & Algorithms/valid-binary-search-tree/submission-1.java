/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean dfs(TreeNode r, int min, int max) {
        if(r == null) {
            return true;
        }
        else if (r.val >= max || r.val <= min) {
            return false;
        }

        return dfs(r.right, r.val, max) && dfs(r.left, min, r.val);
    }
}
