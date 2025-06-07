class Solution {
    private boolean isSame(TreeNode p, TreeNode q){
        if (p == null && q == null)return true;
        if (p == null || q == null || p.val != q.val)return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    private TreeNode Inverse(TreeNode node){
        if(node == null)return null;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        Inverse(node.left);
        Inverse(node.right);
        return node;
    }
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, Inverse(root.right));
    }
}
