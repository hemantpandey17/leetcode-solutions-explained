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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
        }
        
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        
        //Checking null conditions
        if(preStart > preorder.length -1 || inStart > inEnd) {
            return null;
        }
        
        //Node to hold the root of tree
        TreeNode root = new TreeNode(preorder[preStart]);
        //Variable to store index of current node in inorder
        int rootIndex = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i]==root.val)
                rootIndex = i;
        }
        //Recursive functions for left and right subtrees
        //Starting from 2nd node of prestart, inIndex is root index, so inIndex-1 has all left nodes
        root.left = helper(preStart+1,inStart,rootIndex-1,preorder,inorder);
        //Starting from inIndex +1 till the end as it has all nodes of right subtree
        // rootIndex - inStart + 1 gives the start index of right subtree nodes 
        root.right = helper(preStart + rootIndex - inStart + 1,rootIndex+1, inEnd, preorder,inorder);
        
        return root;
    }
        
}
