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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true; // direction flag which signifies the order in which we add elements to the sub-list
        
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>(); // Sublist for one level
            int size = queue.size();
            for(int i=0; i< size; i++) {
                TreeNode n = queue.poll();
                if(flag==true) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0,n.val); // insert value at the 0th index, this will make the elements to be added in reverse order
                }
                if(n.left!=null)
                queue.add(n.left);
                if(n.right!=null)
                queue.add(n.right);
            }
            
            answer.add(tmp);
            flag = !flag; // changing direction at every level, for root, it is true, then for 1st level, we will add it in reverse order
        }
        
        return answer;
        
        
        
    }
}
