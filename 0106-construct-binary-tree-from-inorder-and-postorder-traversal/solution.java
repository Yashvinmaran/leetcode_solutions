class Solution {
    private TreeNode helper(int[] inorder, int inlo, int inhi,int[] postorder, int postlo, int posthi) {
        if (inlo > inhi || postlo > posthi) return null;
        TreeNode root = new TreeNode(postorder[posthi]);
        int rootIndex = inlo;
        while (rootIndex <= inhi && inorder[rootIndex] != root.val)rootIndex++;
        int leftSize = rootIndex - inlo;
        root.left = helper(inorder, inlo, rootIndex - 1, postorder, postlo, postlo + leftSize - 1);
        root.right = helper(inorder, rootIndex + 1, inhi,postorder, postlo + leftSize, posthi - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder, 0, n - 1, postorder, 0, n - 1);
    }
}

