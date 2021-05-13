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
    public TreeNode sortedArrayToBST(int[] nums) {
         if(nums.length==0) {
             return null;
         }
         TreeNode  root = convert(nums,0,nums.length-1);
         return root;
        
    }
    
    private TreeNode convert(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        System.out.println(mid);
        TreeNode tempRoot = new TreeNode(nums[mid]);
        tempRoot.left = convert(nums,start,mid-1);
        tempRoot.right = convert(nums,mid+1,end);
        return tempRoot;
    }
}
