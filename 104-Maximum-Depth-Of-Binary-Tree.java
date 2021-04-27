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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}

/*
Complexity analysis

Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.

Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the best case (the tree is completely balanced), the height of the tree would be \log(N). Therefore, the space complexity in this case would be O(log(N)).
*/

/*
BFS

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
	Deque<TreeNode> dq = new ArrayDeque<>();
        int depth = 0, next = 0;
        TreeNode cur;
        dq.offer(root);
        
        while (!dq.isEmpty()) {
            depth++;
            next = dq.size();
            for (int i = 0; i < next; ++i) {
                cur = dq.poll();
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
            }
        }
        return depth;
    }
}
*/
