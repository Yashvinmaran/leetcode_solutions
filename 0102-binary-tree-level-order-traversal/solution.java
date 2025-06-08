class Solution {
    private int Level(TreeNode root){
        if(root == null)return 0;
        return Math.max(Level(root.left), Level(root.right)) + 1;
    }
    private void Built(TreeNode root, int i, List<Integer> list){
        if(root == null)return;
        if(i == 1)list.add(root.val);
        Built(root.left, i-1, list);
        Built(root.right, i-1, list);
    } 
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = Level(root);
        for (int i = 1; i<=n; i++){
            List<Integer> list = new ArrayList<>();
            Built(root,i,list);
            ans.add(list);
        }
        return ans;
    }
}
