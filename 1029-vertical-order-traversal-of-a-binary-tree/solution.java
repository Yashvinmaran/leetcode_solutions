class Solution {
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>(); 

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;
        
        map.computeIfAbsent(col, k -> new TreeMap<>())
           .computeIfAbsent(row, k -> new ArrayList<>())
           .add(root.val);
        
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, 0);
        
        for (int col : map.keySet()) {
            List<Integer> colList = new ArrayList<>();
            for (int row : map.get(col).keySet()) {
                List<Integer> nodes = map.get(col).get(row);
                Collections.sort(nodes);
                colList.addAll(nodes);
            }
            result.add(colList);
        }
        
        return result;
    }
}

