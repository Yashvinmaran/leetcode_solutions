class Solution {

    private static int maxSum;

    private static int solve(TreeNode root){
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int bottomMax = root.val + left + right;

        int leftOrRightMax = Math.max(left, right) + root.val;

        int rootMax = root.val;

        maxSum = Math.max(Math.max(Math.max(rootMax, maxSum), leftOrRightMax), bottomMax);

        return Math.max(leftOrRightMax, rootMax);
    }

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        solve(root);

        return maxSum;
    }
}
