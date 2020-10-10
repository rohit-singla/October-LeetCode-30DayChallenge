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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] S = data.split(",");
        Queue<String> queue = new LinkedList();
        for(String s: S) queue.add(s);
        return d(queue);
    }
    
    public TreeNode d(Queue <String> queue) {
        while(!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals("")) return null;
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = d(queue);
            node.right = d(queue);
            return node;
        }
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;