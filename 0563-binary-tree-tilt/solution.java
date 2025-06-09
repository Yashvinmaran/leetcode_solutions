class Solution {
    private int totalTilt = 0;

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int leftSum = helper(node.left);
        int rightSum = helper(node.right);

        totalTilt += Math.abs(leftSum - rightSum);

        return node.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        helper(root);
        return totalTilt;
    }
}

