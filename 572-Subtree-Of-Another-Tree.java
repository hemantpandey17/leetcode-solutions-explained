/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Explained well in editorial solution
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    
    private boolean isEqual(TreeNode s, TreeNode t) {
           if(s==null && t==null)
            return true;
        if(s==null || t==null)
            return false;
        return s.val == t.val && isEqual(s.left,t.left) && isEqual(s.right,t.right);
        
    }
    
    private boolean traverse(TreeNode s, TreeNode t) {
     return  s!=null && ( isEqual(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}
