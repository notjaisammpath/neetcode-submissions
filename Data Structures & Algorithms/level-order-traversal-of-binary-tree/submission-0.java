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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList();
            for(int i = 0; i < size; i++) {
                TreeNode k = q.poll();
                if(k.left != null) q.offer(k.left);
                if(k.right != null) q.offer(k.right);
                l.add(k.val); 
            }
            result.add(l);
        }
        return result;
    }
}