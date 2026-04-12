class Solution {
    private TreeNode helper(int[] preorder, int prelo, int prehi, int[] postorder, int postlo, int posthi) {

        if (prelo > prehi || postlo > posthi) return null;

        TreeNode root = new TreeNode(preorder[prelo]);

        if (prelo == prehi) return root;

        int leftRoot = preorder[prelo + 1];

        int idx = postlo;
        while (postorder[idx] != leftRoot) idx++;

        int leftSize = idx - postlo + 1;

        root.left = helper(preorder, prelo + 1, prelo + leftSize, postorder, postlo, idx);

        root.right = helper(preorder, prelo + leftSize + 1, prehi, postorder, idx + 1, posthi - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return helper(preorder, 0, n - 1, postorder, 0, n - 1);
    }
}
