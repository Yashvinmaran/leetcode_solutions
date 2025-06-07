class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        construct(root, path, result, targetSum);
        return result;
    }

    private void construct(TreeNode node, List<Integer> path, List<List<Integer>> result, int target) {
        if (node == null) return;

        path.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            result.add(new ArrayList<>(path));
        }

        construct(node.left, path, result, target);
        construct(node.right, path, result, target);
        path.remove(path.size() - 1);
    }
}

