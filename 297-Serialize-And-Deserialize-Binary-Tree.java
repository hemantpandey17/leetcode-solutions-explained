 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String splitter = ",";
    private String nullNo = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root,StringBuilder sb) {
        if(root==null) {
            sb.append(nullNo).append(splitter);
        }
        else {
            sb.append(root.val).append(splitter);
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        String[] strs = data.split(splitter);
        for(int i=0;i<strs.length;i++) {
            nodes.offer(strs[i]);
        }
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if(val.equals(nullNo)) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
