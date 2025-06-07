class Solution {
    private int depth(TreeNode node){
        if(node == null)return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
    private void Level(TreeNode root, int i, List<Integer>list){
        if(root == null)return;
        if(i == 1)list.add(root.val);
        Level(root.left, i-1, list);
        Level(root.right, i-1, list);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)return ans;
        int n = depth(root);
        for (int i = 1; i<=n; i++){
            List<Integer>list = new ArrayList<>();
            Level(root,i,list);
            ans.add(list);
        }
       for (int i = 0; i < ans.size(); i++) {
        if (i % 2 == 1) {
            Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
}
