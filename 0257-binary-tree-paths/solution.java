class Solution {
    private void construct(TreeNode node, String path, List<String> result){
        if (node != null) {
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) {
                result.add(path);
            } else {
                path += "->";
                construct(node.left, path, result);
                construct(node.right, path, result);
            }
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root != null){
            construct(root, "",ans);
        }
        return ans;
    }
}
