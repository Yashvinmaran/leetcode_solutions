class Solution {

    private static void solve(TreeNode root, int target, int sum, List<List<Integer>> ans, List<Integer> curr) {
        if (root == null) return;

        sum += root.val;
        curr.add(root.val);

        if (root.left == null && root.right == null) {
            if (target == sum) {
                ans.add(new ArrayList<>(curr));
            }
        }

        solve(root.left, target, sum, ans, curr);
        solve(root.right, target, sum, ans, curr);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        int sum = 0;

        solve(root, targetSum, sum, ans, new ArrayList<>());

        return ans;
    }
}
