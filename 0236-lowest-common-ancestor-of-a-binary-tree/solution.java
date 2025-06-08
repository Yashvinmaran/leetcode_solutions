// class Solution {
//     public boolean contains(TreeNode root, TreeNode node){
//         if(root == null)return false;
//         if (root == node)return true;
//         return (contains(root.left,node) || contains(root.right,node));
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null || (p == root || q == root))return root;
//         if(p == q)return p;
//         boolean leftp = contains(root.left, p);
//         boolean rightq = contains(root.right, q);
//         if(leftp && rightq)return root;
//         if(leftp && !rightq)return lowestCommonAncestor(root.left, p, q);
//         if(!leftp && rightq)return lowestCommonAncestor(root.right, p, q);
//         if(!leftp && !rightq)return root;
//         return null;
//     }
// }

//Second or More efficient and optimised way
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}

