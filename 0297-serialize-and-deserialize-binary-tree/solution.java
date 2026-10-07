

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
        if (root == null) return "";

        Queue<TreeNode> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        qu.offer(root);

        while (!qu.isEmpty()) {
            TreeNode node = qu.poll();
            
            if (node == null) {
                sb.append("null ");
                continue;
            }
            
            sb.append(node.val).append(" ");
            qu.offer(node.left);
            qu.offer(node.right);
        }

        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        int i = 1;

        while(!qu.isEmpty() && i < str.length){
            
            TreeNode node = qu.poll();

            if(!str[i].equals("null")){

                TreeNode leftChild = new TreeNode(Integer.parseInt(str[i]));
                node.left = leftChild;
                qu.offer(leftChild);
            }
            i++;

            if(!str[i].equals("null")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(str[i]));
                node.right = rightChild;
                qu.offer(rightChild);
            }
            i++;

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

