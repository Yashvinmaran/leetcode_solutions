class Solution {
    
    private static boolean helper(TreeNode root, TreeNode max, TreeNode min){
        if(root == null) return true;

        if(max != null && max.val <= root.val)return false;
        if(min != null && min.val >= root.val)return false;

        return helper(root.left, root, min) && helper(root.right, max, root);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}
