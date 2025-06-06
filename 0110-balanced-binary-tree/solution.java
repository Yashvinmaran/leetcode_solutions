class Solution {
    private int height(TreeNode root){
        if(root == null || (root.left == null && root.right == null))return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int left = height(root.left);
        if(root.left != null)left++;
        int right = height(root.right);
        if(root.right != null)right++;
        int diff = Math.abs(left - right);
        if(diff > 1)return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }
}
