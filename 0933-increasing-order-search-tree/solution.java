class Solution {
    TreeNode newRoot = null;
    public TreeNode increasingBST(TreeNode root) {
        DFS(root);
        return newRoot;
    }

    private void DFS(TreeNode root){
        if(root == null){
            return;
        }
        DFS(root.right);
        newRoot = new TreeNode(root.val, null, newRoot);
        DFS(root.left);
    }
}
