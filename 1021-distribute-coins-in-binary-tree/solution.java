class Solution {
    private static int count;
    private static int dfs(TreeNode root){
        if(root == null)return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);

        count += (Math.abs(left) + Math.abs(right));
        return  (root.val - 1) + left + right;
    }
    public int distributeCoins(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }
}
