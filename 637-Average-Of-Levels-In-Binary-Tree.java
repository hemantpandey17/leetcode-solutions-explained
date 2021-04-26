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
      public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

          /*
          We have applied BFS, we start with inserting root in the queue.
          We calculate the size of queue, and poll out elements equal to size of elements.
          We calculate the sum and append it to the result list, then we do the same for left
          and right childs.
          
          */
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) 
                    q.offer(node.left);
                if(node.right != null) 
                    q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
        }
}
