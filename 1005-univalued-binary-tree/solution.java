class Solution {
    private void helper(TreeNode root, Set<Integer>set){
        if(root == null)return;
        set.add(root.val);
        helper(root.left, set);
        helper(root.right, set);
    }
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        helper(root, set);
        return set.size() == 1;
    }
}
