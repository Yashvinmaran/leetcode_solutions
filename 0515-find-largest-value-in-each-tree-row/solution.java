class Solution {
    private int height(TreeNode root){
        if(root == null)return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    private int helper(TreeNode root, int max, int level, int idx){
        if(root == null)return max;
        if(idx == level)max = Math.max(root.val, max);
        
        int left = helper(root.left, max, level, idx + 1);
        int right = helper(root.right, max, level, idx + 1);

        return Math.max(left, right);
    }
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)return new ArrayList<>();
        int depth = height(root);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < depth; i++){
            ans.add(helper(root, Integer.MIN_VALUE, i, 0));
        }
        return ans;
    }
}
