/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}*/

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        
        Stack<TreeNode []> stack = new Stack<>();
        stack.push(new TreeNode[] {t1,t2});
        
        while(!stack.isEmpty()) {
            TreeNode[] temp = stack.pop();
            temp[0].val+=temp[1].val;
            if(temp[0].left!=null && temp[1].left!=null)
                stack.push(new TreeNode[] {temp[0].left,temp[1].left});
            if(temp[0].left==null && temp[1].left!=null)
                temp[0].left = temp[1].left;
            if(temp[0].right!=null && temp[1].right!=null)
                stack.push(new TreeNode[] {temp[0].right,temp[1].right});
            if(temp[0].right==null && temp[1].right!=null)
                temp[0].right = temp[1].right;
        }
        return t1;
    }
}
