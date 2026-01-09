class Solution {
    int[] sum = new int[10_001];
    int levels;

    public int maxLevelSum(TreeNode root) {
        levels = 1;
        visit(root, 1);
        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        for (int level = 1; level <= levels; level++) {
            if (sum[level] > max) {
                max = sum[level];
                maxLevel = level;
            }
        }
        return maxLevel;
    }

    private void visit(TreeNode node, int level) {
        if (level > levels) {
            levels = level;
        }
        sum[level] += node.val;
        if (node.left != null) {
            visit(node.left, level + 1);
        }
        if (node.right != null) {
            visit(node.right, level + 1);
        }
    }
}
