class Solution {
    private Integer prev = null;
    private boolean helper(TreeNode root) {
        if (root == null) return true;

        if (!helper(root.left)) return false;

        if (prev != null && root.val <= prev) return false;
        prev = root.val;

        if (!helper(root.right)) return false;

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
}

