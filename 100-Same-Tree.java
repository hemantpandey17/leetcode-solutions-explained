/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
        {
            return true;
        }
        else if(p==null || q==null)
        {
            return false;
        }
        if(p.val==q.val)
        {
            return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
        }
        else{
        return false;
        }
         
    }
}

/*
Complexity Analysis

Time complexity : {O}(N), where N is a number of nodes in the tree, since one visits each node exactly once.

Space complexity : {O}(logN) in the best case of completely balanced tree and O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
*/
