class Solution {

    private static int maxSum;

    private static int solve(TreeNode root){
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int maxBottom = (left + right + root.val);

        int maxLeftOrRight = (Math.max(left, right) + root.val);

        int onlyRoot = root.val;

        maxSum = Math.max(maxSum, Math.max(maxLeftOrRight, Math.max(maxBottom, onlyRoot)));

        return Math.max(onlyRoot, maxLeftOrRight);

    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;

        solve(root);

        return maxSum;
    }
}
