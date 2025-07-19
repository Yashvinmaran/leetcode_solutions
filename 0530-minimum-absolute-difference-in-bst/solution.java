class Solution {
    int prev = Integer.MAX_VALUE;
    int num = Integer.MAX_VALUE;
    private void helper(TreeNode root){
        if(root == null)return;
        helper(root.left);
        num = Math.min((Math.abs(prev - root.val)), num);
        prev = root.val;
        helper(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return num;
    }
}
