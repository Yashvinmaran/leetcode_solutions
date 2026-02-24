class Solution {
    private int helper(TreeNode root, int curr){
        if(root == null)return 0;
        curr = curr*2 + root.val;
        if(root.left == null && root.right == null) return curr;
        int ans = 0;
        if(root.left != null) {
            ans += helper(root.left, curr);
        }
        if(root.right != null){
            ans +=  helper(root.right, curr);
        }
        return ans;
    }
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }
}
