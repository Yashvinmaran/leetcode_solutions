class Solution {

    private int preIdx = 0; 

    private int findIndex(int[] in, int element, int n) {
        for (int i = 0; i < n; i++) {
            if (element == in[i]) return i;
        }
        return -1;
    }

    private TreeNode solve(int[] pre, int[] in, int preStartIndex, int preEndIndex, int n) {
        if (preIdx >= n || preStartIndex > preEndIndex) return null;

        int element = pre[preIdx++];
        int inorderIndex = findIndex(in, element, n);

        TreeNode root = new TreeNode(element);

        root.left = solve(pre, in, preStartIndex, inorderIndex - 1, n);
        root.right = solve(pre, in, inorderIndex + 1, preEndIndex, n);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        preIdx = 0;
        return solve(preorder, inorder, 0, n - 1, n);
    }
}

