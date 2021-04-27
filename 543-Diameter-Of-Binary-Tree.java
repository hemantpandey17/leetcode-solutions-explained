/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        // helper function was required as we had to return ans
        helper(root);
        return ans;
    }
    
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        ans = Math.max(ans, left+right);
        return Math.max(left,right) + 1;
        
    }
}
