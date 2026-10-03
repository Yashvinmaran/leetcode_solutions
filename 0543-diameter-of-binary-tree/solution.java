// class Solution {
//     int maxDiameter = 0; 

//     public int diameterOfBinaryTree(TreeNode root) {
//         calculateHeight(root);
//         return maxDiameter;
//     }

//     // Helper function that returns the height of the node
//     private int calculateHeight(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         // Recursively find the height of left and right subtrees
//         int leftHeight = calculateHeight(root.left);
//         int rightHeight = calculateHeight(root.right);

//         // Update the global maximum diameter if the path through the 
//         // current node (leftHeight + rightHeight) is larger
//         maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

//         // Return the height of the current subtree to the parent call
//         return 1 + Math.max(leftHeight, rightHeight);
//     }
// }









class Solution {

    private static int height(TreeNode root){
        if(root == null)return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null)return 0;

        int maxDiameter = 0;

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(root);

        while(!qu.isEmpty()){

            TreeNode node = qu.poll();

            int left  = height(node.left);
            int right = height(node.right);

            maxDiameter = Math.max(maxDiameter, left + right);

            if(node.left != null) qu.offer(node.left);
            if(node.right != null) qu.offer(node.right);
        }

        return maxDiameter;
    }
}
