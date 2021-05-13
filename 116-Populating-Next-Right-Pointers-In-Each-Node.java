/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        /*if(root == null)
            return;
    
        if(root.left!=null) {
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }
            
        connect(root.left);
        connect(root.right);*/
        
        TreeLinkNode levelStart = root;
        while(levelStart != null) {
            TreeLinkNode curr = levelStart;
            while(curr != null) {
                if(curr.left != null) {
                    curr.left.next = curr.right;
                }
                if(curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }
}
