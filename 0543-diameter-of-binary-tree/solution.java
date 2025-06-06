class Solution {
    public int height(TreeNode root){
        if (root == null || (root.left == null && root.right == null))return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int count = height(root.left) + height(root.right);
        if(root.left != null)count++;
        if(root.right != null)count++;
        int max = Math.max(left, Math.max(right,count));
        return max;
    }
}
