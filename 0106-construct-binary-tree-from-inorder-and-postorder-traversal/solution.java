class Solution {
    private int postIdx;

    private TreeNode solve(int[] in, int[] post, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;

        int rt = post[postIdx];
        TreeNode root = new TreeNode(rt);
        
        postIdx--;

        int pos = map.get(rt);

        root.right = solve(in, post, pos + 1, end, map);
        root.left = solve(in, post, start, pos - 1, map);

        return root;
    }

    public TreeNode buildTree(int[] in, int[] post) {
        int n = in.length;
        postIdx = n - 1; 
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(in[i], i);
        }

        return solve(in, post, 0, n - 1, map);
    }
}

